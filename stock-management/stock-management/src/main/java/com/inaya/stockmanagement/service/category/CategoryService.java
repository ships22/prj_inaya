package com.inaya.stockmanagement.service.category;

import com.inaya.stockmanagement.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category add(Category category);

    Category update(Category category);

    List<Category> getAll();

    Optional<Category> findById(Long id);

    void delete(Long id);

}
