package com.shiva.service;

import com.shiva.model.BookDto;
import com.shiva.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void add(BookDto book){
        bookRepository.save(book.toEntity());
    }
}
