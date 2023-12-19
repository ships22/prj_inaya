package com.inaya.stockmanagement.service.product;

import com.inaya.stockmanagement.model.Product;
import com.inaya.stockmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * @param product
     * @return
     */
    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    /**
     * @param product
     * @return
     */
    @Override
    public Product update(Product product) {
        return productRepository.saveAndFlush(product);
    }

    /**
     * @return
     */
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
