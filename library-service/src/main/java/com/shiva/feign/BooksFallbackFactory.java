package com.shiva.feign;

import com.shiva.model.Book;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BooksFallbackFactory implements FallbackFactory<BookClient> {

    @Override
    public BookClient create(Throwable throwable) {
        return new BookClient() {
            @Override
            public List<Book> getBooks() {
                return Arrays.asList(
                        new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development")
                );
            }

            @Override
            public Book get(Long id) {
                return new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development");
            }
        };
    }
}
