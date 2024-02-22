package org.example.question_1_2.service.impl;

import org.example.question_1_2.entity.RoleEntity;
import org.example.question_1_2.entity.UserEntity;
import org.example.question_1_2.model.ERole;
import org.example.question_1_2.payload.request.SignupRequest;
import org.example.question_1_2.repository.RoleRepository;
import org.example.question_1_2.repository.UserRepository;
import org.example.question_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void saveUser(SignupRequest request) {
        Set<String> strRole = request.getStrRoles();
        Set<RoleEntity> roles = new HashSet<>();

        if(strRole == null){
           RoleEntity userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
                   .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

            roles.add(userRole);
        }
        else {
            strRole.forEach(role -> {
                switch (role){
                    case "admin":
                        RoleEntity adminRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    default:
                        RoleEntity userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        UserEntity userEntity =  new UserEntity(request.getEmail(),request.getUsername(),
                encoder.encode(request.getPassword()), roles);

        userEntity.setCreatedAt(new Date());

        userRepository.save(userEntity);
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
