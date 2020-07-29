package com.shiva.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shiva.user.exception.UserNotFoundException;
import com.shiva.user.model.User;
import com.shiva.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    @ApiOperation(value = "Get all users", nickname = "Get all users")
    @HystrixCommand(fallbackMethod = "defaultUsers")
    public List<User> all() {
        return userService.findAll();
    }

    public List<User> defaultUsers() {
        List<User> users = Arrays.asList(new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com"));
        return users;
    }

    @GetMapping("/{user_id}")
    @ApiOperation(value = "Get User for the Id")
    public User get(@ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) throws UserNotFoundException {
        return userService.findById(id).orElseThrow(() -> new UserNotFoundException("Invalid Id  : " + id));
    }

    @PostMapping
    @ApiOperation(value = "Add a User")
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{user_id}")
    @ApiOperation(value = "Delete the User")
    public void delete(@ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) throws UserNotFoundException {
        userService.deleteById(id);
    }

    @PutMapping("/{user_id}")
    @ApiOperation(value = "Update User data for the Id")
    public User update(@RequestBody User user, @ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) {
        Optional<User> findUser = userService.findById(id);
        if (findUser.isPresent()) {
            User inUser = findUser.get();
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
