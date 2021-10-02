package com.company.addedTest;

import com.company.PasswordChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddedPasswordCheckerTests {

    private PasswordChecker passwordChecker;

    @BeforeEach
    void setUp(){
        passwordChecker = new PasswordChecker(5);
    }
    @Test
    void passwordLength_nullRecieved_returnsFalse(){
        assertEquals(false, passwordChecker.validate(null));
    }

    @Test
    void passwordLength_validPassword_returnsTrue(){
        assertEquals(true, passwordChecker.validate("Password123!"));
    }

}
