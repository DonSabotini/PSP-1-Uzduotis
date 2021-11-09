package com.psp.Lab3.validators;

import com.psp.Lab3.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
public class UserValidatorTest {

    UserValidator userValidator = new UserValidator("$%","LT",5);
    @Test
    void createUserValidatorTest() {
        UserValidator userValidator = new UserValidator("&*","EN",7);
        assertEquals("&*", userValidator.getSpecialsymbols());
        assertEquals("EN", userValidator.getCountrycode());
        assertEquals(7, userValidator.getMinlength());
    }

    @Test
    void validateTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        assertDoesNotThrow(() -> userValidator.validate(user));
    }
    @Test
    void passwordInvalidShouldThrowExceptionTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "aswor");
        assertThrows(ResponseStatusException.class,() -> userValidator.validate(user));
    }
    @Test
    void emailInvalidShouldThrowExceptionTest() {
        User user = new User("name",  "lastname", "+37069999999", "emailg.com", "adress", "Passwor$");
        assertThrows(ResponseStatusException.class,() -> userValidator.validate(user));
    }
    @Test
    void phonenumberInvalidShouldThrowExceptionTest() {
        User user = new User("name",  "lastname", "+37069999A", "email@gmail.com", "adress", "Passwor$");
        assertThrows(ResponseStatusException.class,() -> userValidator.validate(user));
    }
}
