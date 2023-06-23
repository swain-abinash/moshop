package com.moshop.backend.repository;

import com.moshop.backend.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository <Customer, String> {
}
