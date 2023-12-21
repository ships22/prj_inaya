package com.inaya.stockmanagement.service.category;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Category;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category add(Category category) throws BaseException;

    Category update(Category category);

    List<Category> getAll();

    Optional<Category> findById(Long id);

    void delete(Long id);

}
