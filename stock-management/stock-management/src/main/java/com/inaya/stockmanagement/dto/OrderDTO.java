package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.OrderDetails;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class OrderDTO {

    private Long id;

    private Date date;

    private String status;

    private BigDecimal vat;

    private Set<OrderDetails> orderDetails;

}
