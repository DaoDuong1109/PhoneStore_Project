package com.example.demo.controller;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
//@CrossOrigin(origins = "http://localhost:9090")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping("/categories")
    public List<CategoryEntity> findALlCate(){
        return service.getCategories();
    }
    @GetMapping("/categoryById/{id}")
    public CategoryEntity findCategoryById(@PathVariable int id){
        return service.getCategoryById(id);
    }
    @PostMapping("/createCategory")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category){
        return service.createCategory(category);
    }

        @PutMapping("/updateById/{id}")
    public CategoryEntity updateCategory(@PathVariable int id, @RequestBody CategoryEntity category){
        CategoryEntity oldCategory=service.getCategoryById(id);

        return service.updateCategory(id, category);
    }
    @DeleteMapping ("/deleteById/{id}")
    public String deleteCateById(@PathVariable int id){
        return service.deleteCategory(id);
    }
}
