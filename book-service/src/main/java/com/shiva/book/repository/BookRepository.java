package com.shiva.repository;

import com.shiva.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface BookRepository extends JpaRepository<Book, Long> {
}
