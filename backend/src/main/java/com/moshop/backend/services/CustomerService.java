package com.moshop.backend.services;

import com.moshop.backend.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    void createCustomer(Customer customer);
    List<Customer> getCustomers();
    Optional<Customer> getCustomer(String customerId);
    void deleteCustomer(String customerId);
    void updateCustomer(String customerId,Customer customer);
    long countAll();
    List<Customer> getActiveCustomer();
    Optional<Customer> customerLogin(String email,String password);
}
