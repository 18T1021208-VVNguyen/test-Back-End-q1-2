package org.example.question_1_2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity extends BaseEntity{

    private String name;

    private Integer quantity;

    private Float price;

    private String description;
}
