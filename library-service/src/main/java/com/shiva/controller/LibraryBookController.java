package com.shiva.controller;

import com.shiva.feign.BookClient;
import com.shiva.model.Book;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/books")
public class LibraryBookController {

    private BookClient bookClient;

    public LibraryBookController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping
    @ApiOperation(value = "Get all books", nickname = "Get all books")
    public List<Book> all() {
        return bookClient.all();
    }

    @GetMapping("/{book_id}")
    @ApiOperation(value = "Get book for the Id")
    public Book get(@ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) {
        return bookClient.get(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a book")
    public Book add(@RequestBody Book book) {
        return bookClient.add(book);
    }

    @DeleteMapping("/{book_id}")
    @ApiOperation(value = "delete a book")
    public void delete(@ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) {
        bookClient.delete(id);
    }

    @PutMapping("/{book_id}")
    @ApiOperation(value = "Update book data for the Id")
    public Book update(@RequestBody Book book, @ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id) {
        return bookClient.update(book, id);
    }
}
