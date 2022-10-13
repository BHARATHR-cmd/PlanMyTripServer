package com.Mindtree.PlanMyTripServer.Service.Impl;

import com.Mindtree.PlanMyTripServer.Model.CategoryEntity;
import com.Mindtree.PlanMyTripServer.Repository.CategoryRepository;
import com.Mindtree.PlanMyTripServer.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryEntity createCategory(CategoryEntity category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity updatedcategory) {

        return this.categoryRepository.save(updatedcategory);
    }

    @Override
    public CategoryEntity getCategory(long cid) {
        return this.categoryRepository.findById(cid).get();
    }

    @Override
    public List<CategoryEntity> getCategories() {
        return  this.categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(long cid) {
        this.categoryRepository.deleteById(cid);

    }
}
