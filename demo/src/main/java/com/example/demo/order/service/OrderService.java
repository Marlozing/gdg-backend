package com.example.demo.order.service;

import com.example.demo.order.dto.OrderCreateRequest;
import com.example.demo.order.dto.OrderUpdateRequest;
import com.example.demo.order.entity.Order;

import java.util.List;

public interface OrderService {
    Long createOrder(OrderCreateRequest request);
    List<Order> getAllOrders();
    com.example.demo.order.entity.Order getOrderById(Long id);
    void updateOrder(Long id, OrderUpdateRequest request);
    void deleteOrder(Long id);
}
