package com.shiva.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Author> authors = new ArrayList<>();
    private String year;
    private String isbn;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
