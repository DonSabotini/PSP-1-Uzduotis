package com.psp.Lab3.repository;

import com.psp.Lab3.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @BeforeEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void saveTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        userRepository.save(user);
        List<User> users = userRepository.findAll();

        assertNotNull(users);
        assertEquals(1, users.size());
        user = userRepository.getById(user.getUserId());
        assertNotNull(user);
        assertEquals("name", user.getName());
    }


    @Test
    public void findAllTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        userRepository.save(user);
        List<User > users = userRepository.findAll();
        assertNotNull(users);
        assertEquals(1, users.size());
    }

    @Test
    public void deleteByIdTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        userRepository.save(user);
        userRepository.deleteById(user.getUserId());
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void getByIdTest() {
        User user1 = new User("name1",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        User user2 = new User("name2",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        userRepository.save(user1);
        userRepository.save(user2);
        User result = userRepository.getById(user2.getUserId());
        assertNotNull(result);
        assertEquals(result, user2);

    }


}
