package com.shiva.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private String year;
    private String isbn;
    private String author;
    private String category;

    public Book(String name, String year, String isbn, String author, String category) {
        this.name = name;
        this.year = year;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
    }
}
