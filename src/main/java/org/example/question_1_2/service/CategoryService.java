package org.example.question_1_2.service;

import org.example.question_1_2.model.CategoryModel;

public interface CategoryService {
    void createCategory(CategoryModel request);
    void deleteCategory(Long id);
    void updateCategory(CategoryModel request);
    Boolean existsByName(String name);
    CategoryModel findById(Long id);

    CategoryModel findByName(String name);

}
