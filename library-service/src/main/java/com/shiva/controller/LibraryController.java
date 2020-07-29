package com.shiva.controller;

import com.shiva.feign.BookClient;
import com.shiva.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {

    public static final String HTTP_ROOM_SERVICE_URL = "http://BOOK-SERVICE/";

    private BookClient bookClient;

    public LibraryController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @GetMapping
    public List<Book> get() {
        return bookClient.getBooks();
    }
}
