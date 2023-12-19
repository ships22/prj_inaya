package com.inaya.stockmanagement.dto;

import com.inaya.stockmanagement.model.Depot;
import lombok.Data;

@Data
public class StockDTO {

    private Long id;

    private int quantity;

    private Depot depot;

}
