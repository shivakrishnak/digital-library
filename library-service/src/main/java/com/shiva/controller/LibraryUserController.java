package com.shiva.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shiva.feign.UserClient;
import com.shiva.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library/users")
public class LibraryUserController {

    private UserClient userClient;

    public LibraryUserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping
    @ApiOperation(value = "Get all users", nickname = "Get all users")
    public List<User> all() {
        return userClient.all();
    }

    @GetMapping("/{user_id}")
    @ApiOperation(value = "Get User for the Id")
    public User get(@ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) {
        return userClient.get(id);
    }

    @PostMapping
    @ApiOperation(value = "Add a User")
    public User add(@RequestBody User user) {
        return userClient.add(user);
    }

    @DeleteMapping("/{user_id}")
    @ApiOperation(value = "Delete the User")
    public void delete(@ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) {
        userClient.delete(id);
    }

    @PutMapping("/{user_id}")
    @ApiOperation(value = "Update User data for the Id")
    public User update(@RequestBody User user, @ApiParam(value = "Id of User", required = true, example = "123") @PathVariable(name = "user_id") Long id) {
        return userClient.update(user, id);
    }


}
