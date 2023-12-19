package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.model.Depot;
import com.inaya.stockmanagement.model.Supplier;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private BigDecimal buyPrice;

    private BigDecimal cost;

    private BigDecimal margin;

    private List<Depot> depotList;

    private Category category;

    private Supplier supplier;

}
