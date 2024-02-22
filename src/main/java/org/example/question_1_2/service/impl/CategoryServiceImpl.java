package org.example.question_1_2.service.impl;

import org.example.question_1_2.entity.CategoryEntity;
import org.example.question_1_2.model.CategoryModel;
import org.example.question_1_2.repository.CategoryRepository;
import org.example.question_1_2.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void createCategory(CategoryModel request) {
       CategoryEntity entity = mapper.map(request, CategoryEntity.class);
       entity.setCreatedAt(new Date());
       categoryRepository.save(entity);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(CategoryModel request) {
        CategoryEntity entity = categoryRepository.findById(request.getId()).get();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setUpdatedAt(new Date());
        categoryRepository.save(entity);
    }

    @Override
    public Boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public CategoryModel findById(Long id) {
         Optional<CategoryEntity> opCategoryEntity = categoryRepository.findById(id);
         if(opCategoryEntity.isPresent()){
             return mapper.map(opCategoryEntity.get(), CategoryModel.class);
         }
         return null;
    }

    @Override
    public CategoryModel findByName(String name) {
        Optional<CategoryEntity> opCategoryEntity = categoryRepository.findByName(name);
        if(opCategoryEntity.isPresent()){
            return mapper.map(opCategoryEntity.get(), CategoryModel.class);
        }
        return null;
    }
}
