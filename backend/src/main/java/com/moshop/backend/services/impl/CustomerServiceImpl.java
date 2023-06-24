package com.moshop.backend.services.impl;

import com.moshop.backend.model.Customer;
import com.moshop.backend.repository.CustomerRepository;
import com.moshop.backend.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.insert(customer);
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(String customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void deleteCustomer(String customerId) {
        var customer = getCustomer(customerId);
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public long countAll() {
        var count = customerRepository.count();
        return count;
    }

    @Override
    public List<Customer> getActiveCustomer() {
        return customerRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<Customer> customerLogin(String email, String password) {
        return customerRepository.findByEmailAndPassword(email,password);
    }
}
