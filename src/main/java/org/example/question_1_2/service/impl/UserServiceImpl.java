package org.example.question_1_2.service.impl;

import org.example.question_1_2.payload.request.SignupRequest;
import org.example.question_1_2.repository.RoleRepository;
import org.example.question_1_2.repository.UserRepository;
import org.example.question_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void saveUser(SignupRequest request) {
        Set<String> strRole = request.getStrRoles();
        if(strRole == null){
//            roleRepository.findByRoleName();
        }
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
