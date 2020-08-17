package com.shiva.feign;

import com.shiva.model.Book;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class BooksFallbackFactory implements FallbackFactory<BookClient> {

    @Override
    public BookClient create(Throwable throwable) {
        return new BookClient() {

            @Override
            public List<Book> all() {
                return Arrays.asList(
                        new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development")
                );
            }

            @Override
            public Book get(Long id) {
                return new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development");
            }

            @Override
            public Book add(Book book) {
                return new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development");
            }

            @Override
            public void delete(Long id) {
                log.info("Deleting book");
            }

            @Override
            public Book update(Book book, Long id) {
                return new Book(1l, "Effective Java", "Joshua Bloch", "2019", "jdu7-3jehd-jdh65", "Software Development");
            }
        };
    }
}
