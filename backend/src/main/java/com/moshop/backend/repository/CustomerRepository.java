package com.moshop.backend.repository;

import com.moshop.backend.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository <Customer, String> {
    List<Customer> findByIsActiveTrue();
    Optional<Customer> findByCustomerEmailAndCustomerPassword(String email, String password);
}
