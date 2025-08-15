package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User createNewUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public ResponseEntity<?> getUserInfo(UUID id) {
        try {
            Optional<User> userInfo = this.userRepository.findById(id);

            if(userInfo.isEmpty()) {
                return new ResponseEntity<>("user not found with this id: " + id, HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(userInfo, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<?> updateUserInfo(UUID id, User user) {
        try {
            Optional<User> existingUser = this.userRepository.findById(id);

            if(existingUser.isEmpty()) {
                return new ResponseEntity<>("user not found with this id: " + id, HttpStatus.NOT_FOUND);
            }

            User updatedUser = existingUser.get();

            if(user.getUsername() != null) {
                updatedUser.setUsername(user.getUsername());
            }

            if(user.getEmail() != null) {
                updatedUser.setEmail(user.getEmail());
            }

            if(user.getBio() != null) {
                updatedUser.setBio(user.getBio());
            }

            userRepository.save(updatedUser);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
