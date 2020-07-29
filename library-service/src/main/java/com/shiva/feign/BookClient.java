package com.shiva.feign;

import com.shiva.model.Book;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "book-service",fallbackFactory = BooksFallbackFactory.class)
public interface BookClient {

    @GetMapping("/books")
    List<Book> getBooks();

    @GetMapping("/books/{book_id}")
    @ApiOperation(value = "Get book for the Id")
    public Book get(@ApiParam(value = "Id of book to return", required = true, example = "123") @PathVariable(name = "book_id") Long id);

}
