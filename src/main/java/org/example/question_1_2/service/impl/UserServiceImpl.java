package org.example.question_1_2.service.impl;

import org.example.question_1_2.payload.request.SignupRequest;
import org.example.question_1_2.repository.UserRepository;
import org.example.question_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(SignupRequest request) {

    }

    @Override
    public Boolean existsByUserName(String username) {
        return userRepository.existsByUserName(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
