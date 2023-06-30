package com.moshop.backend.services;

import com.moshop.backend.model.dto.OrderRequestDTO;
import com.moshop.backend.model.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * <h3>Creates a new order for the specified customer.</h3>
     *
     * @param customerId The unique identifier of the customer.
     * @param orderRequestDTO     The order to be created.
     */
    void createOrder(String customerId, OrderRequestDTO orderRequestDTO);

    /**
     * <h3>Retrieves a list of all orders in the system.</h3>
     *
     * @return A list of all orders.
     */
    List<Order> getOrders();

    /**
     *<h3> Retrieves a list of orders for the specified customer.</h3>
     *
     * @param customerId The unique identifier of the customer.
     * @return A list of orders for the specified customer.
     */
    List<Order> getOrders(String customerId);

    /**
     * <h3>Retrieves the order with the specified order ID for the specified customer.</h3>
     *
     * @param orderId    The unique identifier of the order.
     * @param customerId The unique identifier of the customer.
     * @return The order with the specified order ID for the specified customer, or null if not found.
     */
    Order getOrder(String orderId, String customerId);

    /**
     * <h3>Retrieves the order with the specified order ID.</h3>
     *
     * @param orderId The unique identifier of the order.
     * @return The order with the specified order ID, or null if not found.
     */
    Order getOrder(String orderId);

    /**
     * <h3>Counts the total number of orders in the system.</h3>
     *
     * @return The total number of orders.
     */
    long countAll();

    /**
     * <h3>Counts the total number of orders for the specified customer.</h3>
     *
     * @param customerId The unique identifier of the customer.
     * @return The total number of orders for the specified customer.
     */
    long countAll(String customerId);
}
