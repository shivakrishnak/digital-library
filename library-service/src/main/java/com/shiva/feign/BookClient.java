package com.shiva.feign;

import com.shiva.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "BOOK-SERVICE", fallbackFactory = BooksFallbackFactory.class)
public interface BookClient {

    @GetMapping("/")
    public List<Book> all();

    @GetMapping("/{book_id}")
    public Book get(@PathVariable(name = "book_id") Long id);

    @PostMapping
    public Book add(@RequestBody Book book);

    @DeleteMapping("/{book_id}")
    public void delete(@PathVariable(name = "book_id") Long id);

    @PutMapping("/{book_id}")
    public Book update(@RequestBody Book book, @PathVariable(name = "book_id") Long id);
}
