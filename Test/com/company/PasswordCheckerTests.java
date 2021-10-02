package com.company;

import com.company.PasswordChecker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTests {

    private PasswordChecker passwordChecker;

    @BeforeEach
    void setUp(){
        passwordChecker = new PasswordChecker(5);
    }

    @Test
    void passwordLength_LengthLessThan5_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("test"));
    }

    @Test
    void passwordLength_LengthMoreThan5_ReturnsTrue(){
        //assertEquals(true, passwordChecker.validate("password123")); should return false because it has no special character or uppercase letter
        assertEquals(false, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_NoUppercaseSymbols_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_HasUppercaseSymbols_ReturnsTrue(){
        //assertEquals(true, passwordChecker.validate("Password123")); should return true because it doesn't have a special character
        assertEquals(false, passwordChecker.validate("Password123"));
    }

    @Test
    void passwordSymbols_NoSpecialSymbols_ReturnsFalse(){
        assertEquals(false, passwordChecker.validate("password123"));
    }

    @Test
    void passwordSymbols_HasSpecialSymbols_ReturnsTrue(){
        //assertEquals(true, passwordChecker.validate("password!@123")); should return false because it has no uppercase letter
        assertEquals(false, passwordChecker.validate("password!@123"));
    }




}
