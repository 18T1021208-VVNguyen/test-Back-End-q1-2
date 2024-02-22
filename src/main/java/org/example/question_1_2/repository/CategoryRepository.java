package org.example.question_1_2.repository;

import org.example.question_1_2.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    Boolean existsByName(String name);

    Optional<CategoryEntity> findByName(String name);

}
