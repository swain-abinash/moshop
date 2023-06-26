package com.moshop.backend.services.impl;

import com.moshop.backend.repository.*;
import com.moshop.backend.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final VariantRepository variantRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    @Override
    public long totalVariants() {
        return variantRepository.count();
    }

    @Override
    public long totalProducts() {
        return productRepository.count();
    }

    @Override
    public long totalCustomers() {
        return customerRepository.count();
    }

    @Override
    public long totalCarts() {
        return cartRepository.count();
    }

    @Override
    public long totalOrders() {
        return orderRepository.count();
    }
}
