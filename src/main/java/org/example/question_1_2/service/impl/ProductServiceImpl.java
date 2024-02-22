package org.example.question_1_2.service.impl;

import org.example.question_1_2.entity.CategoryEntity;
import org.example.question_1_2.entity.ProductEntity;
import org.example.question_1_2.model.CategoryModel;
import org.example.question_1_2.model.ProductModel;
import org.example.question_1_2.repository.CategoryRepository;
import org.example.question_1_2.repository.ProductRepository;
import org.example.question_1_2.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void createProduct(ProductModel request) {
        ProductEntity entity = mapper.map(request, ProductEntity.class);
        entity.setCategoryEntity(categoryRepository.findById(request.getCategoryId()).get());
        entity.setCreatedAt(new Date());
        productRepository.save(entity);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(ProductModel request) {
        ProductEntity entity =  productRepository.findById(request.getId()).get();
        entity.setName(request.getName());
        entity.setQuantity(request.getQuantity());
        entity.setPrice(request.getPrice());
        entity.setDescription(request.getDescription());
        entity.setMadeIn(request.getMadeIn());
        entity.setCategoryEntity(categoryRepository.findById(request.getCategoryId()).get());
        entity.setUpdatedAt(new Date());
        productRepository.save(entity);
    }

    @Override
    public boolean CheckExistsCategory(Long categoryId) {
        if(productRepository.findFirstByCategoryEntity(categoryId).isPresent() ){
            return true;
        }
        return false;
    }

    @Override
    public Boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public ProductModel findById(Long id) {
        Optional<ProductEntity> opProductEntity = productRepository.findById(id);
        if(opProductEntity.isPresent()){
            return mapper.map(opProductEntity.get(), ProductModel.class);
        }
        return null;
    }

    @Override
    public ProductModel findByName(String name) {
        Optional<ProductEntity> opProductEntity = productRepository.findByName(name);
        if(opProductEntity.isPresent()){
            return mapper.map(opProductEntity.get(), ProductModel.class);
        }
        return null;
    }

}
