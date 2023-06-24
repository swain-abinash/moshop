package com.moshop.backend.controller;

import com.moshop.backend.model.Customer;
import com.moshop.backend.model.LoginRequest;
import com.moshop.backend.services.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerServiceImpl.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerServiceImpl.getCustomers();
    }

    @GetMapping("/{customerId}")
    public Optional<Customer> getCustomer(@PathVariable String customerId) {
        return customerServiceImpl.getCustomer(customerId);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        customerServiceImpl.deleteCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        customerServiceImpl.updateCustomer(customerId, customer);
    }

    @GetMapping("/count")
    public long countAll() {
        return customerServiceImpl.countAll();
    }

    @GetMapping("/active")
    public List<Customer> getActiveCustomer() {
        return customerServiceImpl.getActiveCustomer();
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> customerLogin(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getCustomerEmail();
        String password = loginRequest.getCustomerPassword();

        var optionalCustomer = customerServiceImpl.customerLogin(email, password);

        if (optionalCustomer.isPresent()) {
            var customer = optionalCustomer.get();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
