package org.example.question_1_2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "categorys")
public class CategoryEntity extends  BaseEntity{

    @NotBlank
    @Column(name = "name" )
    private String name;

    @NotBlank
    @Column(name = "description")
    private String description;


}
