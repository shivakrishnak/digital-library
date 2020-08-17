package com.shiva.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shiva.user.controller.UserController;
import com.shiva.user.model.User;
import com.shiva.user.service.UserService;
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
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UserService bookService;


    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    void getAllUsers_HttpStatusOk() throws Exception {
        when(bookService.findAll())
                .thenReturn(getUsers());

        mockMvc.perform(get("/users/")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void getAUser_HttpStatusOk() throws Exception {
        when(bookService.findById(eq(1L)))
                .thenReturn(java.util.Optional.of(getUser()));

        mockMvc.perform(
                get("/users/{user_id}", 1L)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    public List<User> getUsers() {
        List<User> users = Arrays.asList(getUser());
        return users;
    }

    private User getUser() {
        return new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com");
    }
}
