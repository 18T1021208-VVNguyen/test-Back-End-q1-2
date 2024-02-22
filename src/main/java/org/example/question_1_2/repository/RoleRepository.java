package org.example.question_1_2.repository;

import org.example.question_1_2.entity.RoleEntity;
import org.example.question_1_2.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRoleName(String roleName);
}
