package com.moshop.backend.services;

import com.moshop.backend.model.entity.Dashboard;

public interface DashboardService {
    /**
     * <h3>Returns the dashboard object.</h3>
     * Having variants, products, customers, carts, orders
     *
     * @return a Dashboard object.
     */
    Dashboard countAll();
}
