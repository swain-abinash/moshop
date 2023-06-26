package com.moshop.backend.services.impl;

import com.moshop.backend.model.dto.CustomerRequestDTO;
import com.moshop.backend.model.entity.Customer;
import com.moshop.backend.repository.CustomerRepository;
import com.moshop.backend.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(CustomerRequestDTO customerRequestDTO) {
        var customer = new Customer();

        customer.setCustomerName(customerRequestDTO.getCustomerName());
        customer.setCustomerAddress(customerRequestDTO.getCustomerAddress());
        customer.setCustomerEmail(customerRequestDTO.getCustomerEmail());
        customer.setCustomerNumber(customerRequestDTO.getCustomerNumber());
        customer.setCustomerPassword(customerRequestDTO.getCustomerPassword());
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setActive(true);

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
        var customer = getCustomer(customerId).orElseThrow();

        customer.setActive(false);
        customer.setUpdatedDate(LocalDateTime.now());

        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {
        var updateCustomer = getCustomer(customerId).orElseThrow();

        updateCustomer.setCustomerName(customer.getCustomerName());
        updateCustomer.setCustomerAddress(customer.getCustomerAddress());
        updateCustomer.setCustomerEmail(customer.getCustomerEmail());
        updateCustomer.setCustomerNumber(customer.getCustomerNumber());
        updateCustomer.setUpdatedDate(LocalDateTime.now());

        customerRepository.save(updateCustomer);
    }

    @Override
    public long countAll() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> getActiveCustomer() {
        return customerRepository.findAllByIsActive(true);
    }

    @Override
    public Optional<Customer> customerLogin(String email, String password) {
        return customerRepository.findByCustomerEmailAndCustomerPassword(email, password);
    }
}
