package com.company.addedTest;

import com.company.EmailValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddedEmailValidatorTests {

    private EmailValidator emailValidator;

    @BeforeEach
    void setUp() {
        emailValidator = new EmailValidator();
    }

    @Test
    void email_nullRecieved_ReturnsFalse() {
        assertEquals(false, emailValidator.validate(null));
    }
    @Test
    void email_containsSpaces_ReturnsFalse() {
        assertEquals(false, emailValidator.validate("emai l@test.com"));
    }
    @Test
    void email_usernameTooLong_returnFalse() {
        assertEquals(false, emailValidator.validate("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@test.com"));
    }
    @Test
    void email_domainTooLong_returnFalse() {
        assertEquals(false, emailValidator.validate("email@testtesttesttesttesttesttesttesttesttestte" +
                "sttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest" +
                "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttest.com"));
    }
    @Test
    void email_domainNameTooShort_ReturnsFalse() {
        assertEquals(false, emailValidator.validate("email@.com"));
    }

    @Test
    void email_TLDTooShort_ReturnsFalse() {
        assertEquals(false, emailValidator.validate("email@test.c"));
    }
    @Test
    void email_TLDDoesNotStartWithALetter_ReturnsFalse() {
        assertEquals(false, emailValidator.validate("email@test.5om"));
    }


}
