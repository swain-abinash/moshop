package com.moshop.backend.controller;

import com.moshop.backend.model.dto.CustomerRequestDTO;
import com.moshop.backend.model.entity.Customer;
import com.moshop.backend.model.entity.LoginRequest;
import com.moshop.backend.services.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerServiceImpl;

    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        customerServiceImpl.createCustomer(customerRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        var customers = customerServiceImpl.getCustomers();

        if (customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(customers);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(customers);
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        var customer = customerServiceImpl.getCustomer(customerId);

        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
        customerServiceImpl.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
        customerServiceImpl.updateCustomer(customerId, customer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        var count = customerServiceImpl.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Customer>> getActiveCustomer() {
        var customers = customerServiceImpl.getActiveCustomer();

        if (!customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(customers);
        }else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> customerLogin(@RequestBody LoginRequest loginRequest) {
        String email = loginRequest.getCustomerEmail();
        String password = loginRequest.getCustomerPassword();

        var optionalCustomer = customerServiceImpl.customerLogin(email, password);

        if (optionalCustomer.isPresent()) {
            var customer = optionalCustomer.get();
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
