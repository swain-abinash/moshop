package com.moshop.backend.services;

import com.moshop.backend.model.Order;

import java.util.List;

public interface OrderService {

    /**
     * Creates a new order for the specified customer.
     *
     * @param customerId The unique identifier of the customer.
     * @param order      The order to be created.
     */
    void createOrder(String customerId, Order order);

    /**
     * Retrieves a list of all orders in the system.
     *
     * @return A list of all orders.
     */
    List<Order> getOrders();

    /**
     * Retrieves a list of orders for the specified customer.
     *
     * @param customerId The unique identifier of the customer.
     * @return A list of orders for the specified customer.
     */
    List<Order> getOrders(String customerId);

    /**
     * Retrieves the order with the specified order ID for the specified customer.
     *
     * @param orderId    The unique identifier of the order.
     * @param customerId The unique identifier of the customer.
     * @return The order with the specified order ID for the specified customer, or null if not found.
     */
    Order getOrder(String orderId, String customerId);

    /**
     * Retrieves the order with the specified order ID.
     *
     * @param orderId The unique identifier of the order.
     * @return The order with the specified order ID, or null if not found.
     */
    Order getOrder(String orderId);

    /**
     * Counts the total number of orders in the system.
     *
     * @return The total number of orders.
     */
    long countAll();

    /**
     * Counts the total number of orders for the specified customer.
     *
     * @param customerId The unique identifier of the customer.
     * @return The total number of orders for the specified customer.
     */
    long countAll(String customerId);
}
