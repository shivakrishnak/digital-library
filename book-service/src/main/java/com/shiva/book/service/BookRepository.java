package com.shiva.book.service;

import com.shiva.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface BookRepository extends JpaRepository<Book, Long> {
}
