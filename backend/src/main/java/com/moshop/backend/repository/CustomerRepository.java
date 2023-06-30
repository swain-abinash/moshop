package com.moshop.backend.repository;

import com.moshop.backend.model.dto.CustomerResponseDTO;
import com.moshop.backend.model.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository <Customer, String> {
    List<CustomerResponseDTO> findAllByIsActive(boolean isActive);
    Optional<CustomerResponseDTO> findByCustomerEmailAndCustomerPassword(String email, String password);
}
