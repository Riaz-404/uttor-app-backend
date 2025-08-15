package com.riazulislam.uttorappbackend.services;

import com.riazulislam.uttorappbackend.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createNewUser(User user);

}
