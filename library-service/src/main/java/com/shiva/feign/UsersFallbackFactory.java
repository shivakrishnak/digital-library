package com.shiva.feign;

import com.shiva.model.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class UsersFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public List<User> all() {
                return Arrays.asList(
                        new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com")
                );
            }

            @Override
            public User get(Long id) {
                return new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com");
            }

            @Override
            public User add(User user) {
                return new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com");
            }

            @Override
            public void delete(Long id) {
                log.info("Deleting user");
            }

            @Override
            public User update(User user, Long id) {
                return new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com");
            }
        };
    }
}
