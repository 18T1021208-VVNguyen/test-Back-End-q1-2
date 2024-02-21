package org.example.question_1_2.security.service;

import jakarta.transaction.Transactional;
import org.example.question_1_2.entity.UserEntity;
import org.example.question_1_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with user name: " + userName));

        return UserDetailsImpl.build(user);
    }
}
