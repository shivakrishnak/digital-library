package com.shiva.user.repository;

import com.shiva.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface BookRepository extends JpaRepository<Book, Long> {
}
