package com.example.secondService.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@Getter
@Setter
public class User implements Serializable {
    private Integer id;
    private String name;
    private List<Book> bookList;
}
