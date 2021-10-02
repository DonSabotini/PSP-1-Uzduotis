package com.company.addedTest;

import com.company.PhoneValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddedPhoneValidatorTests {


    private PhoneValidator phoneValidator;

    @BeforeEach
    void setUp() {
        phoneValidator = new PhoneValidator("+370", 12);
    }

    @Test
    void phoneNumber_nullRecieved_returnsFalse() {
        assertEquals(false, phoneValidator.validate(null));
    }

    @Test
    void phoneNumber_numberTooShort_returnsFalse() {
        assertEquals(false, phoneValidator.validate("+319701"));
    }


}