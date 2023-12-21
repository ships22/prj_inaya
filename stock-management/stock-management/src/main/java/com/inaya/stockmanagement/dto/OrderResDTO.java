package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.OrderDetails;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class OrderResDTO {

    private Long id;
    private LocalDateTime date;
    private String status;
    private BigDecimal priceWithVat;
    private int vat;
    private List<OrderDetails> orderDetails;

}
