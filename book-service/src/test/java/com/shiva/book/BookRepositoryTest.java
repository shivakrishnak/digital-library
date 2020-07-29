package com.shiva.book;

import com.shiva.book.model.Book;
import com.shiva.book.repository.BookRepository;
import com.shiva.book.util.BookUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BookRepository repository;

    @Test
    public void whenFindById_thenReturnBook() {
        // given
        Book book = new Book(1l, "Effective Java", "Test Author", "2019", BookUtil.getUUID(), "Software Development");
        entityManager.merge(book);
        entityManager.flush();

        // when
        Optional<Book> found = repository.findById(book.getId());

        // then
        Assertions.assertNotNull(found.get());
        assertThat(found.get().getId())
                .isEqualTo(book.getId());
    }

}