package com.example.secondService.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable {
    private Integer id;
    private String title;
    private List<Author> authorList;
    private User user;
}
