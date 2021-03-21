package com.example.secondService;

import com.example.secondService.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    private final String urlBooks = "http://library/books";

    public BookController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        objectMapper = new ObjectMapper();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        List<?> books = restTemplate.getForObject(urlBooks, List.class);
        assert books != null;
        return books.stream().map(o -> objectMapper.convertValue(o, Book.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") Long bookId) {
        return restTemplate.getForObject(urlBooks + "/" + bookId, Book.class);
    }

}
