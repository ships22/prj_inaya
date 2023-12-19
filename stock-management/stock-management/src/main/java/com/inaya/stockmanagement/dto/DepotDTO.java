package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.Product;
import com.inaya.stockmanagement.model.Stock;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class DepotDTO {

    private Long id;

    private String name;

    private String address;

    private String email;

    private String phone;

    private Set<Stock> stock = new HashSet<>();

    private List<Product> productList;

}
