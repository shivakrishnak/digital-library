package com.shiva.user.controller;

import com.shiva.user.exception.UserNotFoundException;
import com.shiva.user.model.User;
import com.shiva.user.service.UserService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired


    @GetMapping
    public List<User> all() {
        return userService.findAll();
    }

    @GetMapping("/{user_id}")
    public User get(@ApiParam(value = "ID of user to return", required = true, example = "123") @PathVariable(name = "user_id") Long id) throws UserNotFoundException {
        return userService.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid Id  : " + id));
    }

    @PostMapping
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{user_id}")
    public void delete(@ApiParam(value = "ID of user to return", required = true, example = "123") @PathVariable(name = "user_id") Long id) throws UserNotFoundException {
        userService.deleteById(id);
    }

    @PutMapping("/{user_id}")
    public User update(@RequestBody User user, @ApiParam(value = "ID of user to return", required = true, example = "123") @PathVariable(name = "user_id") Long id) {
        Optional<User> findUser = userService.findById(id);
        if (findUser.isPresent()) {
            User inUser = findUser.get();
            inUser.setUsername(user.getUsername());
            inUser.setFirstName(user.getFirstName());
            inUser.setLastName(user.getLastName());
            inUser.setPhoneNumber(user.getPhoneNumber());
            inUser.setEmail(user.getEmail());
            userService.save(inUser);
        } else {
            user.setId(id);
            userService.save(user);
        }
        return user;
    }
}
