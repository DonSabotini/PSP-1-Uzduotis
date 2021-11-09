package com.psp.Lab3.controller;


import com.psp.Lab3.model.User;
import com.psp.Lab3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId){
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.add(user), HttpStatus.CREATED);
    }
    @PutMapping("/user")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity deleteVartotojas(@PathVariable int userId){
        userService.removeById(userId);
        return new ResponseEntity(HttpStatus.OK);
    }

}
