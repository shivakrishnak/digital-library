package com.shiva.book.controller;

import com.shiva.book.exception.BookNotFoundException;
import com.shiva.book.model.Book;
import com.shiva.book.service.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(name = "/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> all(){
        return bookRepository.findAll();
    }

    @GetMapping("/{book_id}")
    public Book get(@PathVariable(name = "book_id")Long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Invalid Id  : " + id));
    }

    @PostMapping
    public Book add(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{book_id}")
    public void delete(@PathVariable(name = "book_id")Long id) throws BookNotFoundException {
        bookRepository.deleteById(id);
    }

    @PutMapping
    public Book update(@RequestBody Book book, Long id){
        Optional<Book> findBook = bookRepository.findById(id);
        if(findBook.isPresent()){
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
