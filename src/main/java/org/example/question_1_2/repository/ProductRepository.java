package org.example.question_1_2.repository;

import org.example.question_1_2.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    Boolean existsByName(String name);

    @Query("""
            SELECT 1 FROM ProductEntity  as P 
            WHERE P.categoryEntity.id = :id
        """)
    Optional<ProductEntity> findFirstByCategoryEntity(Long id);

    Optional<ProductEntity> findByName(String name);
}
