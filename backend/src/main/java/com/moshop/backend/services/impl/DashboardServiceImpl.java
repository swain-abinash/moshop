package com.moshop.backend.services.impl;

import com.moshop.backend.model.entity.Dashboard;
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
    public Dashboard countAll() {
        var dashboard = new Dashboard();

        dashboard.setTotalVariants(variantRepository.count());
        dashboard.setTotalProducts(productRepository.count());
        dashboard.setTotalCustomers(customerRepository.count());
        dashboard.setTotalCarts(cartRepository.count());
        dashboard.setTotalOrders(orderRepository.count());

        return dashboard;
    }
}
