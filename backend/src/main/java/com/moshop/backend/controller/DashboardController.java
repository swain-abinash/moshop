package com.moshop.backend.controller;

import com.moshop.backend.services.impl.DashboardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardServiceImpl dashboardServiceImpl;

    @GetMapping("/total-variants")
    public ResponseEntity<Long> totalVariants() {
        var count = dashboardServiceImpl.totalVariants();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/total-products")
    public ResponseEntity<Long> totalProducts() {
        var count = dashboardServiceImpl.totalProducts();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/total-customers")
    public ResponseEntity<Long> totalCustomers() {
        var count = dashboardServiceImpl.totalCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/total-carts")
    public ResponseEntity<Long> totalCarts() {
        var count = dashboardServiceImpl.totalCarts();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/total-orders")
    public ResponseEntity<Long> totalOrders() {
        var count = dashboardServiceImpl.totalOrders();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
}
