package com.inaya.stockmanagement.dto;

import lombok.Data;

@Data
public class OrderProductReq {

    private Long productId;
    private Integer quantity;
}
