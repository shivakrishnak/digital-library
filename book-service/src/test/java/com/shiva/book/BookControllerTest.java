package com.shiva.book;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiva.book.controller.BookController;
import com.shiva.book.model.Book;
import com.shiva.book.service.BookService;
import com.shiva.book.util.BookUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = BookController.class)
public class BookControllerTest {

    @Autowired
    private BookController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @BeforeEach
    void printApplicationContext() {
/*        Arrays.stream(applicationContext.getBeanDefinitionNames())
                .map(name -> applicationContext.getBean(name).getClass().getName())
                .sorted()
                .forEach(System.out::println);*/
    }

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void getAllBooks_HttpStatusOk() throws Exception {
        when(bookService.findAll())
                .thenReturn(getBooks());

        mockMvc.perform(get("/books/")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void getABook_HttpStatusOk() throws Exception {
        when(bookService.findById(eq(1L)))
                .thenReturn(java.util.Optional.of(getBook()));

        mockMvc.perform(
                get("/books/{book_id}", 1L)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    public List<Book> getBooks() {
        List<Book> books = Arrays.asList(getBook());
        return books;
    }

    private Book getBook() {
        return new Book(1l, "Effective Java", "Joshua Bloch", "2019", BookUtil.getUUID(), "Software Development");
    }
}
