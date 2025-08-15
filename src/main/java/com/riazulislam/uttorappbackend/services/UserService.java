package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface UserService {

    User createNewUser(User user);

    ResponseEntity<?> getUserInfo(UUID id);

    ResponseEntity<?> updateUserInfo(UUID id, User user);
}
