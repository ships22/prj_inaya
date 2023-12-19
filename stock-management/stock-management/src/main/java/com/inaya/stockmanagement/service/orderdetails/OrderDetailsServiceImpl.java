package com.inaya.stockmanagement.service.orderdetails;

import com.inaya.stockmanagement.model.OrderDetails;
import com.inaya.stockmanagement.repository.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }


    /**
     * @param orderDetails
     * @return
     */
    @Override
    public OrderDetails add(OrderDetails orderDetails) {
        return orderDetailsRepository.save(orderDetails);
    }

    /**
     * @param orderDetails
     * @return
     */
    @Override
    public OrderDetails update(OrderDetails orderDetails) {
        return orderDetailsRepository.saveAndFlush(orderDetails);
    }

    /**
     * @return
     */
    @Override
    public List<OrderDetails> getAll() {
        return orderDetailsRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<OrderDetails> findById(Long id) {
        return orderDetailsRepository.findById(id);
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        orderDetailsRepository.deleteById(id);
    }
}
