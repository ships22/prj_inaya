package com.inaya.stockmanagement.service.product;

import com.inaya.stockmanagement.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product add(Product product);

    Product update(Product product);

    List<Product> getAll();

    Optional<Product> findById(Long id);

    void delete(Long id);

}
