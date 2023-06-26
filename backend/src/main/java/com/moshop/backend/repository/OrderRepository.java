package com.moshop.backend.repository;

import com.moshop.backend.model.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByCustomerId(String customerId);

    Order findByOrderIdAndCustomerId(String orderId, String customerId);

    Order findByOrderId(String orderId);

    long countByCustomerId(String customerId);
}
