package org.example.question_1_2.service;

import org.example.question_1_2.payload.request.SignupRequest;
import org.springframework.stereotype.Service;

public interface UserService {
    void saveUser(SignupRequest request);
    Boolean existsByUserName(String username);
    Boolean existsByEmail(String email);




}