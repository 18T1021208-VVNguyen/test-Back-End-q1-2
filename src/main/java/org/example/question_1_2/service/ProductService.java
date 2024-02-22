package org.example.question_1_2.service;

import org.example.question_1_2.model.CategoryModel;
import org.example.question_1_2.model.ProductModel;

import java.util.List;

public interface ProductService {
    void createProduct(ProductModel request);
    void deleteProduct(Long id);

    void updateProduct(ProductModel request);

    boolean CheckExistsCategory(Long categoryId);

    Boolean existsByName(String name);

    ProductModel findById(Long id);

    ProductModel findByName(String name);

}
