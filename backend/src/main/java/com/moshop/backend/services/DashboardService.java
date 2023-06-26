package com.moshop.backend.services;

public interface DashboardService {
    /**
     * Returns the total count of variants.
     *
     * @return The total count of variants as a long value.
     */
    long totalVariants();

    /**
     * Returns the total count of products.
     *
     * @return The total count of products as a long value.
     */
    long totalProducts();

    /**
     * Returns the total count of customers.
     *
     * @return The total count of customers as a long value.
     */
    long totalCustomers();

    /**
     * Returns the total count of carts.
     *
     * @return The total count of carts as a long value.
     */
    long totalCarts();

    /**
     * Returns the total count of orders.
     *
     * @return The total count of orders as a long value.
     */
    long totalOrders();
}
