package com.shiva.feign;

import com.shiva.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "USER-SERVICE", fallbackFactory = UsersFallbackFactory.class)
public interface UserClient {

    @GetMapping("/")
    public List<User> all();

    @GetMapping("/{user_id}")
    public User get(@PathVariable(name = "user_id") Long id);

    @PostMapping
    public User add(@RequestBody User user);

    @DeleteMapping("/{user_id}")
    public void delete(@PathVariable(name = "user_id") Long id);

    @PutMapping("/{user_id}")
    public User update(@RequestBody User user, @PathVariable(name = "user_id") Long id);
}
