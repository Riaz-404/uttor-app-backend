package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.User;
import com.riazulislam.uttorappbackend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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
}
