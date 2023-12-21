package com.inaya.stockmanagement.controller;

import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.manager.CategoryManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/categories")
public class CategoryController {

    private final CategoryManager categoryManager;

    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategory() {
        return categoryManager.getAllCategory();
    }

    @GetMapping(value = "/category/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return categoryManager.getCategoryById(id);
    }

    @PostMapping(value = "/category")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryManager.saveCategory(categoryDTO);
    }

    @PutMapping(value = "/category")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryManager.updateCategory(categoryDTO);
    }
    @DeleteMapping(value = "/category/{id}")
    public String deleteCategory(@PathVariable Long id){
        return categoryManager.deleteCategory(id);
    }
}
