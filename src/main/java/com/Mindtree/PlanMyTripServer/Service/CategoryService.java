package com.Mindtree.PlanMyTripServer.Service;

import com.Mindtree.PlanMyTripServer.Model.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoryService {

    public CategoryEntity createCategory(CategoryEntity category);
    public CategoryEntity updateCategory(CategoryEntity category);
    public CategoryEntity getCategory(long cid);
    public List<CategoryEntity> getCategories();
    public void deleteCategory(long cid);
}
