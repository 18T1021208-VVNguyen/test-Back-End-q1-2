package org.example.question_1_2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products",uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_PRODUCT_NAME", columnNames = "name") })
public class ProductEntity extends BaseEntity{

    @Column(name = "name" )
    @NotBlank
    private String name;

    @Column(name = "quantity")
    @NotNull
    private Integer quantity;

    @Column(name = "price")
    @NotNull
    private Float price;

    @Column(name = "madeIn")
    private String madeIn;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity categoryEntity;
}
