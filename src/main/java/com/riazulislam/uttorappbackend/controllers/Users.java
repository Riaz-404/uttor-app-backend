package com.riazulislam.uttorappbackend.controllers;

import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfo(@PathVariable UUID id) {
        return this.userService.getUserInfo(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateUserInfo(@PathVariable UUID id,@RequestBody User user) {
        return this.userService.updateUserInfo(id, user);
    }
}
