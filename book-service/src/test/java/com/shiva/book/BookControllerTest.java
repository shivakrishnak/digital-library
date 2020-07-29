package com.shiva.book;

import com.shiva.book.controller.BookController;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
//@WithMockUser
public class BookControllerTest {
}
