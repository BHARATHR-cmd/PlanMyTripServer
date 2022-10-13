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

    @PutMapping("/{cid}")
    public CategoryEntity updateCategory(@RequestBody CategoryEntity updatedcategory,@PathVariable Long cid){
        CategoryEntity category=this.categoryService.getCategory(cid);
        category.setCtitle(updatedcategory.getCtitle());
        category.setCDescription(updatedcategory.getCDescription());
        category.setCImage(updatedcategory.getCImage());
        return this.categoryService.updateCategory(category);

    }

    @DeleteMapping("/{cid}")
    public void  deleteCategory(@PathVariable Long cid){
        this.categoryService.deleteCategory(cid);
    }

}
