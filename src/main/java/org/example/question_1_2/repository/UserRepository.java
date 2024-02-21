package org.example.question_1_2.repository;


import org.example.question_1_2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Boolean existsByUserName(String username);

    Boolean existsByEmail(String email);

    Optional<UserEntity> findByUserName(String userName);

    Optional<UserEntity> findByEmail(String email);
}
