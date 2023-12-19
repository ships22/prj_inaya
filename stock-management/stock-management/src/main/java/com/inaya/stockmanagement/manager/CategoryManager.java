package com.inaya.stockmanagement.manager;

import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.service.category.CategoryService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CategoryManager {

    private final CategoryService categoryService;

    public CategoryManager(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return modelToDto(categoryService.add(category));
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return modelToDto(categoryService.update(category));
    }

    public CategoryDTO getCategoryById(Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(this::modelToDto).orElseGet(CategoryDTO::new);
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categoryList = categoryService.getAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryList.forEach(data -> categoryDTOList.add(modelToDto(data)));
        return categoryDTOList;
    }

    public String deleteCategory(Long id) {
        try {
            categoryService.delete(id);
            return "Category with " + id + " has been deleted";
        } catch (Exception e) {
            return "Category with " + id + " not found";
        }
    }

    private CategoryDTO modelToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }


}
