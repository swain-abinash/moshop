package com.moshop.backend.repository;

import com.moshop.backend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CartRepository extends MongoRepository<Cart, String> {
}
