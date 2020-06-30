package com.shiva.model;

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
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "book_generator")
    @TableGenerator(name = "book_generator", table = "book_id_generator")
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();
    private String year;
    private String isbn;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Book(String name, List<Author> authors, String year, String isbn, String category) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.isbn = isbn;
        this.category = new Category(category);
    }
}
