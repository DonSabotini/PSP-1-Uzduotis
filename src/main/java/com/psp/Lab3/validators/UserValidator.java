package com.psp.Lab3.validators;

import com.company.Validators.EmailValidator;
import com.company.Validators.PasswordChecker;
import com.company.Validators.PhoneValidator;
import com.psp.Lab3.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserValidator {
    String specialsymbols;
    String countrycode;
    int minlength;

    PasswordChecker passwordChecker;
    PhoneValidator phoneValidator;
    EmailValidator emailValidator;

    public UserValidator(String specialsymbols, String countrycode, int minlength) {
        this.specialsymbols = specialsymbols;
        this.countrycode = countrycode;
        this.minlength = minlength;
        passwordChecker = new PasswordChecker(specialsymbols);
        phoneValidator = new PhoneValidator();
        emailValidator = new EmailValidator();
    }

    public String getSpecialsymbols() {
        return specialsymbols;
    }

    public void setSpecialsymbols(String specialsymbols) {
        this.specialsymbols = specialsymbols;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public int getMinlength() {
        return minlength;
    }

    public void setMinlength(int minlength) {
        this.minlength = minlength;
    }

    public User validate(User user) {
        String password = user.getPassword();
        String phonenumber = user.getPhonenumber();
        String email = user.getEmail();

        validatePassword(password);
        validateEmail(email);
        phonenumber = validatePhonenumber(phonenumber);
        user.setPhonenumber(phonenumber);

        return user;
    }


    private void validatePassword(String password) {
        boolean valid = passwordChecker.HasSpecialSymbols(password)
                & passwordChecker.HasUppercaseLetters(password)
                & passwordChecker.MeetsLengthRequirement(password, minlength);
        if (!valid)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private void validateEmail(String email) {
        boolean valid = emailValidator.ContainsAtSymbol(email) &
                !emailValidator.ContainsForbiddenSymbols(email) &
                emailValidator.HasGoodDomainName(email) &
                emailValidator.HasGoodTLD(email);
        if (!valid)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    private String validatePhonenumber(String phonenumber) {
        String error1 = "Such country code does not exist";
        String error2 = "Country code does not match";
        String error3 = "Country code does not match";

        phonenumber = phoneValidator.ChangePrefix(phonenumber);
        String testPhonenumber = phonenumber;

        if (testPhonenumber.charAt(0) == '+')
            testPhonenumber = testPhonenumber.substring(1, testPhonenumber.length());
        if (!phoneValidator.ConsistsOfNumbers(testPhonenumber))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        testPhonenumber = phonenumber;
        if (!phoneValidator.ValidateNumberLenghtByCountryCode(countrycode, testPhonenumber))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        testPhonenumber = phoneValidator.ValidateOtherCountryNumbers(countrycode, testPhonenumber);
        if (testPhonenumber.equals(error1))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (testPhonenumber.equals(error2))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        if (testPhonenumber.equals(error3))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return phonenumber;

    }

}
