package com.moshop.backend.services.impl;

import com.moshop.backend.model.Order;
import com.moshop.backend.repository.OrderRepository;
import com.moshop.backend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public void createOrder(String customerId, Order order) {
        order.setCustomerid(customerId);
        orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrders(String customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order getOrder(String orderId, String customerId) {
        return orderRepository.findByOrderIdAndCustomerId(orderId, customerId);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public long countAll() {
        return orderRepository.count();
    }

    @Override
    public long countAll(String customerId) {
        return orderRepository.countByCustomerId(customerId);
    }
}
