package com.inaya.stockmanagement.service.order;

import com.inaya.stockmanagement.model.Order;
import com.inaya.stockmanagement.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    /**
     * @param order
     * @return
     */
    @Override
    public Order add(Order order) {
        return orderRepository.save(order);
    }

    /**
     * @param order
     * @return
     */
    @Override
    public Order update(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    /**
     * @return
     */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
