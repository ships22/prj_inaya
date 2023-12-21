package com.inaya.stockmanagement.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrderReqDTO {

    private String clientName;
    private String clientEmail;
    private String clientAddress;
    private List<OrderProductReq> products;

}
