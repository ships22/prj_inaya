package com.inaya.stockmanagement.repository;

import com.inaya.stockmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product>findByName(String name);

    @Query("SELECT p.name," +
            "p.buyPrice, " +
            "p.cost, " +
            "p.margin" +
            " FROM Product p" +
            " WHERE p.id = ?1")
    Product getProductInfo(Long id);


}
