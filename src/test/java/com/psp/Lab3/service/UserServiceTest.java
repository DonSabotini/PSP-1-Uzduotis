package com.psp.Lab3.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

import com.psp.Lab3.model.User;
import com.psp.Lab3.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository repository;

    @InjectMocks
    UserService service;


    @Test
    void testFindAll() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        List<User> users = new ArrayList<>();
        users.add(user);

        when(repository.findAll()).thenReturn(users);

        List<User> found = service.getAllUsers();

        verify(repository).findAll();

        assertEquals(1, found.size());
    }

    @Test
    void testFindById() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        when(repository.findById(Mockito.anyInt())).thenReturn(java.util.Optional.of(user)); // static method when daromas tada, kai metodas returnina reiksme
        User found = service.getById(1);
        verify(repository).findById(Mockito.anyInt()); // verifying mock call 1 time
        assertNotNull(found);
        assertEquals(user,found);
    }
    @Test
    void testAdd() {
        User user = new User("name",  "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        when(repository.save(Mockito.any(User.class))).thenReturn(user);

        User added = service.add(user);
        verify(repository).save(Mockito.any(User.class));
        assertNotNull(added);
    }

    @Test
    void testUpdate() {
        User user = new User("name", "lastname", "+37069999999", "email@gmail.com", "adress", "Passwor$");
        service.update(user);
        verify(repository).save(Mockito.any(User.class));
    }

    @Test
    void testDeleteById() {
        service.removeById(1);
        verify(repository).deleteById(Mockito.anyInt());
    }



}
