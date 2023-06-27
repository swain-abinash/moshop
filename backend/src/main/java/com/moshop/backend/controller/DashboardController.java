package com.moshop.backend.controller;

import com.moshop.backend.model.entity.Dashboard;
import com.moshop.backend.services.*;
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
    private final VariantService variantService;
    private final ProductService productService;
    private final CustomerService customerService;
    private final CartService cartService;
    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<Dashboard> countAll() {
        var dashboard = new Dashboard();

        dashboard.setTotalVariants(variantService.countAll());
        dashboard.setTotalProducts(productService.countAll());
        dashboard.setTotalCustomers(customerService.countAll());
        dashboard.setTotalCarts(cartService.countAll());
        dashboard.setTotalOrders(orderService.countAll());

        return ResponseEntity.status(HttpStatus.OK).body(dashboard);
    }
}
