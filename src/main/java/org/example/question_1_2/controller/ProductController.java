package org.example.question_1_2.controller;

import jakarta.validation.Valid;
import org.example.question_1_2.model.CategoryModel;
import org.example.question_1_2.model.ProductModel;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create-product")
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductModel request){
        // check unique product name
        if(productService.existsByName(request.getName())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: product name is already !"));
        }
        // check categoryId exist in Category.
        if(categoryService.findById(request.getCategoryId()) == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found category id ! " + request.getCategoryId()));
        }

        productService.createProduct(request);
        return ResponseEntity.ok(new MessageResponse("Product create successfully!"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-product")
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductModel request ) {
        if(request.getId() == null ||  productService.findById(request.getId()) == null ){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found product id !" + request.getId()));
        }

        if(categoryService.findById(request.getCategoryId()) == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found category id ! " + request.getCategoryId()));
        }

        ProductModel modelProduct = productService.findByName(request.getName());
        if(modelProduct != null  && !modelProduct.getId().equals(request.getId())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: product name is already !"));
        }

        productService.updateProduct(request);
        return ResponseEntity.ok(new MessageResponse("Product updated successfully!"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        if(productService.findById(id) == null ){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: not found product id ! " + id));
        }

        productService.deleteProduct(id);
        return ResponseEntity.ok(new MessageResponse("Product delete successfully!"));
    }
}
