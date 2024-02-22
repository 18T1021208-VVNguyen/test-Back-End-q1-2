package org.example.question_1_2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity extends BaseEntity{

    @Column(name = "name" )
    @NotBlank
    private String name;

    @Column(name = "quantity")
    @NotBlank
    private Integer quantity;

    @Column(name = "price")
    @NotNull
    private Float price;

    @Column(name = "madeIn")
    @NotNull
    private String madeIn;

    @Column(name = "description")
    @NotBlank
    private String description;
}
