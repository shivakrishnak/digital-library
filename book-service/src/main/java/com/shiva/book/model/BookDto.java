package com.shiva.book.model;

import java.util.ArrayList;
import java.util.List;

public class BookDto {

    private String name;
    private String year;
    private String isbn;
    private List<Author> authors = new ArrayList<>();
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookDto(String name, List<Author> authors, String year, String isbn, String category) {
        this.name = name;
        this.authors = authors;
        this.year = year;
        this.isbn = isbn;
        this.category = category;
    }

    public Book toEntity(){
        return new Book(this.getName(),this.getAuthors(),this.getYear(),this.getIsbn(),this.getCategory());
    }

    public static class Builder{
        private String name;
        private List<Author> authors = new ArrayList<>();
        private String year;
        private String isbn;
        private String category;

        public Builder() { }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder authors(List<Author> authors) {
            this.authors = authors;
            return this;
        }

        public Builder year(String year) {
            this.year = year;
            return this;
        }

        public Builder isbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder category(String category) {
            this.category = category;
            return this;
        }

        public BookDto build(){
            return new BookDto(name,authors,year,isbn,category);
        }
    }
}
