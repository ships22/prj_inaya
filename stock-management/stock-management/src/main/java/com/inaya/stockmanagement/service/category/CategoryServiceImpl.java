package com.inaya.stockmanagement.service.category;

import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

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
    public Category add(Category category) {
        return categoryRepository.save(category);
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
