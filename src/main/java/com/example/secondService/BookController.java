package com.example.secondService;

import com.example.secondService.models.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Data
public class BookController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final String urlBooks = "http://localhost:8080/books";

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
