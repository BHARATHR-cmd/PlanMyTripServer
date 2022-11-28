package com.Mindtree.PlanMyTripServer.Controller;


import com.Mindtree.PlanMyTripServer.Model.CategoryEntity;
import com.Mindtree.PlanMyTripServer.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")

public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public CategoryEntity createcategory(@RequestBody CategoryEntity category){

        return this.categoryService.createCategory(category);

    }
    @GetMapping("/{cid}")
    public CategoryEntity getCategory(@PathVariable Long cid){
        return this.categoryService.getCategory(cid);
    }
    @GetMapping("/")
    public List<CategoryEntity> getCategory(){
        return this.categoryService.getCategories();
    }

    @PutMapping("/")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity updatedcategory){

        return this.categoryService.updateCategory(updatedcategory);

    }

    @DeleteMapping("/{cid}")
    public void  deleteCategory(@PathVariable Long cid){
        this.categoryService.deleteCategory(cid);
    }

}
