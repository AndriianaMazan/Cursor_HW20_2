package com.example.secondService.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author implements Serializable {
    private Integer id;
    private String name;
    private List<Book> bookList;
}
