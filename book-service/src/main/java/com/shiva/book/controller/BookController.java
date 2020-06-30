package com.shiva.controller;

import com.shiva.exception.BookNotFoundException;
import com.shiva.model.Book;
import com.shiva.repository.BookRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> all() {
        return bookRepository.findAll();
    }

    @GetMapping("/{book_id}")
    public Book get(@ApiParam(value = "ID of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Invalid Id  : " + id));
    }

    @PostMapping
    public Book add(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/{book_id}")
    public void delete(@ApiParam(value = "ID of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) throws BookNotFoundException {
        bookRepository.deleteById(id);
    }

    @PutMapping("/{book_id}")
    public Book update(@RequestBody Book book, @ApiParam(value = "ID of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) {
        Optional<Book> findBook = bookRepository.findById(id);
        if (findBook.isPresent()) {
            Book inBook = findBook.get();
            inBook.setName(book.getName());
            inBook.setIsbn(book.getIsbn());
            inBook.setYear(book.getYear());
            inBook.setAuthors(book.getAuthors());
            inBook.setCategory(book.getCategory());
            bookRepository.save(inBook);
        } else {
            book.setId(id);
            bookRepository.save(book);
        }
        return book;
    }
}
