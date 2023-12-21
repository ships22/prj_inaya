package com.inaya.stockmanagement.controller;

import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.dto.OrderReqDTO;
import com.inaya.stockmanagement.dto.OrderResDTO;
import com.inaya.stockmanagement.manager.OrderManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/orders")
public class OrderController {

    private final OrderManager orderManager;


    public OrderController(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    @PostMapping(value = "/order")
    public ResponseEntity<OrderResDTO> addOrder(@RequestBody OrderReqDTO orderReqDTO) {
        return orderManager.saveOrder(orderReqDTO);
    }

    @GetMapping
    public ResponseEntity<List<OrderResDTO>> getAllOrder() {
        return orderManager.getAllOrder();
    }
}
