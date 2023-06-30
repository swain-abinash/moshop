package com.moshop.backend.services.impl;

import com.moshop.backend.model.dto.CustomerRequestDTO;
import com.moshop.backend.model.dto.CustomerResponseDTO;
import com.moshop.backend.model.entity.Customer;
import com.moshop.backend.repository.CustomerRepository;
import com.moshop.backend.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
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

        BeanUtils.copyProperties(customerRequestDTO, customer);
        
        customer.setCreatedDate(LocalDateTime.now());
        customer.setUpdatedDate(LocalDateTime.now());
        customer.setActive(true);

        customerRepository.insert(customer);
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        var customers = customerRepository.findAll();

        return customers.stream().map(customer -> {
            var responseDTO = new CustomerResponseDTO();
            BeanUtils.copyProperties(customer, responseDTO);
            return responseDTO;
        }).toList();

    }

    @Override
    public Optional<CustomerResponseDTO> getCustomer(String customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow();
        var responseDTO = new CustomerResponseDTO();

        BeanUtils.copyProperties(customer, responseDTO);

        return Optional.of(responseDTO);
    }

    @Override
    public void deleteCustomer(String customerId) {
        var responseDTO = getCustomer(customerId).orElseThrow();

        responseDTO.setActive(false);
        responseDTO.setUpdatedDate(LocalDateTime.now());

        var customer = new Customer();
        BeanUtils.copyProperties(responseDTO, customer);

        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(String customerId, CustomerRequestDTO customerRequestDTO) {
        var responseDTO = getCustomer(customerId).orElseThrow();

        BeanUtils.copyProperties(customerRequestDTO, responseDTO);

        var customer = new Customer();

        customer.setUpdatedDate(LocalDateTime.now());

        BeanUtils.copyProperties(responseDTO, customer);

        customerRepository.save(customer);
    }

    @Override
    public long countAll() {
        return customerRepository.count();
    }

    @Override
    public List<CustomerResponseDTO> getActiveCustomer() {
        return customerRepository.findAllByIsActive(true);
    }

    @Override
    public Optional<Optional<CustomerResponseDTO>> customerLogin(String email, String password) {
        return Optional.ofNullable(customerRepository.findByCustomerEmailAndCustomerPassword(email, password));
    }
}
