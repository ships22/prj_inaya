package com.inaya.stockmanagement.service.orderdetails;

import com.inaya.stockmanagement.model.OrderDetails;

import java.util.List;
import java.util.Optional;

public interface OrderDetailsService {

    OrderDetails add(OrderDetails orderDetails);

    OrderDetails update(OrderDetails orderDetails);

    List<OrderDetails> getAll();

    Optional<OrderDetails> findById(Long id);

    void delete(Long id);

}
