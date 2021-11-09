package com.psp.Lab3.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void getNameTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "name";
        assertEquals(user.getName(), expected);
    }

    @Test
    void getSirnameTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "lastname";
        assertEquals(user.getLastname(), expected);
    }

    @Test
    void getPhonenumberTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "+37069999999";
        assertEquals(user.getPhonenumber(), expected);
    }

    @Test
    void getEmailTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "email@gmail.com";
        assertEquals(user.getEmail(), expected);
    }

    @Test
    void getAdressTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "adress";
        assertEquals(user.getAdress(), expected);
    }

    @Test
    void getPasswordTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        String expected = "Passwor$";
        assertEquals(user.getPassword(), expected);
    }


    @Test
    void setNameTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setName("name1");
        String expected = "name1";
        assertEquals(user.getName(), expected);
    }

    @Test
    void setSirnameTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setLastname("lastname1");
        String expected = "lastname1";
        assertEquals(user.getLastname(), expected);
    }

    @Test
    void setPhonenumberTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setPhonenumber("37069999990");
        String expected = "37069999990";
        assertEquals(user.getPhonenumber(), expected);
    }

    @Test
    void setEmailTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setEmail("email1@gmail.com");
        String expected = "email1@gmail.com";
        assertEquals(user.getEmail(), expected);
    }

    @Test
    void setAdressTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setAdress("adress1");
        String expected = "adress1";
        assertEquals(user.getAdress(), expected);
    }

    @Test
    void setPasswordTest() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        user.setPassword("Passwor$1");
        String expected = "Passwor$1";
        assertEquals(user.getPassword(), expected);
    }
}