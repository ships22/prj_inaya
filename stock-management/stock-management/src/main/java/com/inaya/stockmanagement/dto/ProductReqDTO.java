package com.inaya.stockmanagement.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProductReqDTO {

    private String name;
    private String description;
    private BigDecimal buyPrice;
    private BigDecimal cost;
    private BigDecimal margin;
    private Long depotId;
    private Long categoryId;
    private Long supplierId;
    private int quantity;


}
