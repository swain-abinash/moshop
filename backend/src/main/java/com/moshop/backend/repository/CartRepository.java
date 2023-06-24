package com.moshop.backend.repository;

import com.moshop.backend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {
    List<Cart> findAllByCustomerId(String customerId);

    Cart findByCartIdAndCustomerId(String cartId, String customerId);

    long countByCustomerId(String customerId);
}
