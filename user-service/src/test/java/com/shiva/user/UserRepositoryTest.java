package com.shiva.user;

import com.shiva.user.model.User;
import com.shiva.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void whenFindById_thenReturnUser() {
        // given
        User user = getUser();
        entityManager.merge(user);
        entityManager.flush();

        // when
        Optional<User> found = repository.findById(user.getId());

        // then
        Assertions.assertNotNull(found.get());
        assertThat(found.get().getId())
                .isEqualTo(user.getId());
    }

    private User getUser() {
        return new User(1L, "shiva", "krishna", "1234567890", "shiva@gmail.com");
    }
}