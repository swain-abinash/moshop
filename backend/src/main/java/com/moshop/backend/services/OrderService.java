package com.moshop.backend.services;

import com.moshop.backend.model.Order;

import java.util.List;


public interface OrderService {
    void createOrder(String customerId, Order order);
    List<Order>getOrders();
    List<Order>getOrders(String customerId);
    Order getOrder(String orderId, String customerId);
    Order getOrder(String orderId);
    long countAll();
    long countAll(String customerId);
}
