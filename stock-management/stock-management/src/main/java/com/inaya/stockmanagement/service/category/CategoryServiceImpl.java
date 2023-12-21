package com.inaya.stockmanagement.service.category;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLNonTransientException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Category add(Category category) throws BaseException{
        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new BaseException("Duplicate entry");
        }
    }

    /**
     * @param category
     * @return
     */
    @Override
    public Category update(Category category) {
        return categoryRepository.saveAndFlush(category);

    }

    /**
     * @return
     */
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
