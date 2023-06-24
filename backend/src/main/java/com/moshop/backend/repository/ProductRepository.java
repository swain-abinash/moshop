package com.moshop.backend.repository;

import com.moshop.backend.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findAllByIsActiveProduct(boolean isActive);
    void delete(boolean isActive);
}
