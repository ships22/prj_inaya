package com.inaya.stockmanagement.manager;

import com.inaya.stockmanagement.constant.STATUS;
import com.inaya.stockmanagement.constant.VAT;
import com.inaya.stockmanagement.dto.CategoryDTO;
import com.inaya.stockmanagement.dto.OrderReqDTO;
import com.inaya.stockmanagement.dto.OrderResDTO;
import com.inaya.stockmanagement.model.Category;
import com.inaya.stockmanagement.model.Order;
import com.inaya.stockmanagement.model.OrderDetails;
import com.inaya.stockmanagement.model.Product;
import com.inaya.stockmanagement.service.order.OrderService;
import com.inaya.stockmanagement.service.orderdetails.OrderDetailsService;
import com.inaya.stockmanagement.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderManager {

    private final OrderService orderService;
    private final OrderDetailsService orderDetailsService;

    private final ProductService productService;

    public OrderManager(OrderService orderService, OrderDetailsService orderDetailsService, ProductService productService) {
        this.orderService = orderService;
        this.orderDetailsService = orderDetailsService;
        this.productService = productService;
    }

    public ResponseEntity<OrderResDTO> saveOrder(OrderReqDTO orderReqDTO) {

        List<OrderDetails> orderDetailsListToAdd = new ArrayList<>();
        orderReqDTO.getProducts().forEach((data) -> {
            OrderDetails orderDetails = new OrderDetails();
            Product product = productService.findById(data.getProductId()).get();
            System.out.println("prod info ****** ok / works : " + product.toString());
            orderDetails.setProductName(product.getName());
            orderDetails.setUnitPrice(
                    product.getBuyPrice()
                            .add(product.getCost())
                            .add(product.getMargin()));
            orderDetails.setQuantity(data.getQuantity());
            orderDetailsListToAdd.add(orderDetails);
        });
        List<OrderDetails> addedOrderDetails = orderDetailsService.addAll(orderDetailsListToAdd);

        Order order = new Order();
        order.setClientName(orderReqDTO.getClientName());
        order.setClientEmail(orderReqDTO.getClientEmail());
        order.setClientAddress(orderReqDTO.getClientAddress());
        order.setStatus(STATUS.PENDING.getValue());
        order.setVat(VAT._10.getValue());
        order.setOrderDetails(addedOrderDetails);

        Order addedOrder = orderService.add(order);

        OrderResDTO orderResDTO = new OrderResDTO();
        orderResDTO.setId(addedOrder.getId());
        orderResDTO.setVat(addedOrder.getVat());
        orderResDTO.setStatus(addedOrder.getStatus());
        orderResDTO.setDate(addedOrder.getDateTime());
        orderResDTO.setPriceWithVat(addedOrder.getPriceWithVat());
        orderResDTO.setOrderDetails(addedOrder.getOrderDetails());

        return new ResponseEntity<>(orderResDTO, HttpStatus.CREATED);
    }

    public ResponseEntity<List<OrderResDTO>>getAllOrder(){
        List<Order> orders = orderService.getAll();
        List<OrderResDTO>orderResDTOS = new ArrayList<>();
        orders.stream().forEach(data->{
            OrderResDTO orderResDTO= new OrderResDTO();
            orderResDTO.setId(data.getId());
            orderResDTO.setDate(data.getDateTime());
            orderResDTO.setStatus(data.getStatus());
            orderResDTO.setVat(data.getVat());
            orderResDTO.setPriceWithVat(data.getPriceWithVat());
            orderResDTO.setOrderDetails(data.getOrderDetails());
            orderResDTOS.add(orderResDTO);
        });
        return new ResponseEntity<>(orderResDTOS, HttpStatus.OK);
    }


}
