package com.shiva.book.model;

public class BookDto {

    private String name;
    private String year;
    private String isbn;
    private String author;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BookDto(String name, String year, String isbn, String author, String category) {
        this.name = name;
        this.year = year;
        this.isbn = isbn;
        this.author = author;
        this.category = category;
    }

    public Book toEntity() {
        return new Book(this.getName(), this.getYear(), this.getIsbn(), this.getAuthor(), this.getCategory());
    }

    public static class Builder {
        private String name;
        private String author;
        private String year;
        private String isbn;
        private String category;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder authors(String author) {
            this.author = author;
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

        public BookDto build() {
            return new BookDto(name, author, year, isbn, category);
        }
    }
}
