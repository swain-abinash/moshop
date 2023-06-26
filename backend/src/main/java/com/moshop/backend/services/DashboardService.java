package com.moshop.backend.services;

import com.moshop.backend.model.entity.Dashboard;

public interface DashboardService {
    /**
     * Returns the dashboard object.
     * Having variants, products, customers, carts, orders
     *
     * @return a Dashboard object.
     */
    Dashboard countAll();
}
