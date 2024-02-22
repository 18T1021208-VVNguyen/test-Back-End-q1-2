package org.example.question_1_2.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {

    private Long id;

    @NotBlank
    private String name;


    @NotNull
    private Integer quantity;

    @NotNull
    private Float price;

    @NotBlank
    private String madeIn;

    @NotBlank
    private String description;

    @NotNull
    private Long categoryId;
}
