package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Users {
    @Autowired
    UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = this.userService.createNewUser(user);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
