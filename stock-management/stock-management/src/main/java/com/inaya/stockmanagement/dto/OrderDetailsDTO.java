package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.Order;
import lombok.Data;

@Data
public class OrderDetailsDTO {

    private Long id;

    private String productName;

    private int quantity;

    private int unitPrice;

    private Order order;

}
