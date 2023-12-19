package com.inaya.stockmanagement.service.order;

import com.inaya.stockmanagement.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order add(Order order);

    Order update(Order order);

    List<Order> getAll();

    Optional<Order> findById(Long id);

    void delete(Long id);

}
