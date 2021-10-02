package com.company;

import com.company.PhoneValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidatorTests {


    private PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        //phoneValidator = new PhoneValidator("LT", 13); you should be able to set the country prefix and the length was incorrect
        phoneValidator = new PhoneValidator("+370", 12);
    } //

    @Test
    void phoneNumber_HasInvalidSymbols_ReturnsFalse() {
        assertEquals(false, phoneValidator.validate("86565028!"));
    }

    @Test
    void phoneNumber_NoInvalidSymbols_ReturnsTrue() {
        assertEquals(true, phoneValidator.validate("865650288"));
    }

    @Test
    void phoneNumber_HasInvalidCountryCode_ReturnsFalse() {
        assertEquals(false, phoneValidator.validate("+3197010281083"));
    }

    @Test
    void phoneNumber_NumberTooLong_ReturnsFalse() {
        assertEquals(false, phoneValidator.validate("+3197010281083"));
    }

    @Test
    void phoneNumber_HasValidCountryCode_ReturnsTrue() {
        assertEquals(true, phoneValidator.validate("+37065650288"));
    }

    @Test
        // same test as above
    void phoneNumber_NumberCorrectLength_ReturnsTrue() {
        assertEquals(true, phoneValidator.validate("+37065650288"));
    }
}