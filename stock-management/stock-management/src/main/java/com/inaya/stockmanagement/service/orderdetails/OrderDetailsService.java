package com.inaya.stockmanagement.service.orderdetails;

import com.inaya.stockmanagement.model.OrderDetails;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderDetailsService {

    OrderDetails add(OrderDetails orderDetails);

    List<OrderDetails>addAll(List<OrderDetails>orderDetailsList);

    OrderDetails update(OrderDetails orderDetails);

    List<OrderDetails> getAll();

    Optional<OrderDetails> findById(Long id);

    void delete(Long id);

}
