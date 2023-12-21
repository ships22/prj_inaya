package com.inaya.stockmanagement.service.product;

import com.inaya.stockmanagement.Exception.BaseException;
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
    public Product add(Product product) throws BaseException {
        try {
            return productRepository.saveAndFlush(product);
        } catch (Exception e) {
            throw new BaseException("Duplicate entry");
        }
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
     * @param id
     * @return
     */
    @Override
    public Product getProductInfo(Long id) {
        return productRepository.getProductInfo(id);
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

        System.out.println("prod id :" + id + "  *******************");
        Optional<Product>product = productRepository.findById(id);
        System.out.println("**********found prod : " + product.get().toString());
        return product;
        //return productRepository.findById(id);
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
