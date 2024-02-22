package org.example.question_1_2.controller;

import jakarta.validation.Valid;
import org.example.question_1_2.model.CategoryModel;
import org.example.question_1_2.payload.response.MessageResponse;
import org.example.question_1_2.service.CategoryService;
import org.example.question_1_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-category")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryModel request ) {
        if ( categoryService.existsByName(request.getName()) ) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: category name is already !"));
        }

        categoryService.createCategory(request);
        return ResponseEntity.ok(new MessageResponse("Category create successfully!"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-category")
    public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryModel request ) {
        if(request.getId() == null ||  categoryService.findById(request.getId()) == null ){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found category id ! " + request.getId()));
        }

        CategoryModel modelCategory = categoryService.findByName(request.getName());
        if(modelCategory != null  && !modelCategory.getId().equals(request.getId())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: category name is already !"));
        }

        categoryService.updateCategory(request);
        return ResponseEntity.ok(new MessageResponse("Category updated successfully!"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        if(categoryService.findById(id) == null ){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found category id ! " + id));
        }

        if(productService.CheckExistsCategory(id)){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: category id is already in product ! " + id));
        }

        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new MessageResponse("Category delete successfully!"));
    }
}
