package com.inaya.stockmanagement.service.product;

import com.inaya.stockmanagement.Exception.BaseException;
import com.inaya.stockmanagement.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product add(Product product) throws BaseException;

    Product update(Product product);

    Product getProductInfo(Long id);

    List<Product> getAll();

    Optional<Product> findById(Long id);

    Optional<Product>findByName(String name);

    void delete(Long id);

}
