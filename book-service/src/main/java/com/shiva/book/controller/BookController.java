package com.shiva.book.controller;

import com.shiva.book.exception.BookNotFoundException;
import com.shiva.book.model.Book;
import com.shiva.book.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired


    @GetMapping
    @ApiOperation(value = "Get all books", nickname = "Get all books")
    public List<Book> all() {
        return bookService.findAll();
    }

    @GetMapping("/{book_id}")
    @ApiOperation(value = "Get book for the Id")
    public Book get(@ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) throws BookNotFoundException {
        return bookService.findById(id).orElseThrow(() -> new BookNotFoundException("Invalid Id  : " + id));
    }

    @PostMapping
    @ApiOperation(value = "Add a book")
    public Book add(@RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/{book_id}")
    @ApiOperation(value = "delete a book")
    public void delete(@ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) throws BookNotFoundException {
        bookService.deleteById(id);
    }

    @PutMapping("/{book_id}")
    @ApiOperation(value = "Update book data for the Id")
    public Book update(@RequestBody Book book, @ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) {
        Optional<Book> findBook = bookService.findById(id);
        if (findBook.isPresent()) {
            Book inBook = findBook.get();
            inBook.setName(book.getName());
            inBook.setIsbn(book.getIsbn());
            inBook.setYear(book.getYear());
            inBook.setAuthors(book.getAuthors());
            inBook.setCategory(book.getCategory());
            bookService.save(inBook);
        } else {
            book.setId(id);
            bookService.save(book);
        }
        return book;
    }
}
