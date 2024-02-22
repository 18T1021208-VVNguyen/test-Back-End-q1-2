package org.example.question_1_2.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryModel {

    private  Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
