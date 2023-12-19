package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.Product;
import lombok.Data;

import java.util.Set;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private Set<Product> productSet;

}
