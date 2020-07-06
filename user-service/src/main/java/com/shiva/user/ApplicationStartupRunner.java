package com.shiva.user;

import com.shiva.user.model.User;
import com.shiva.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private UserService userService;

    @Autowired
    public ApplicationStartupRunner(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {
        userService.save(new User(1L, "sivakrsna", "shiva", "krishna", "1234567890", "shiva@gmail.com"));
        userService.save(new User(2L, "testUsername", "testFirstName", "testLastName", "0987654321", "test@gmail.com"));
        userService.save(new User(3L, "test", "fname", "lname", "99999999999", "test@gmail.com"));
    }
}
