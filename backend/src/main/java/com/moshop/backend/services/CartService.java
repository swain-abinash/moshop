package com.moshop.backend.services;

import com.moshop.backend.model.entity.Cart;

import java.util.List;


public interface CartService {
    /**
     * Creates a new cart for the specified customer.
     *
     * @param customerId The ID of the customer for whom the cart is being created.
     * @param cart       The Cart object representing the cart to be created.
     */
    void createCart(String customerId, Cart cart);

    /**
     * Retrieves a list of carts.
     *
     * @return A list of Cart objects representing the available carts.
     */
    List<Cart> getCarts();

    /**
     * Retrieves a cart for the specified customer ID, if available.
     *
     * @param customerId The ID of the customer for whom to retrieve the cart.
     * @return An Optional object containing the Cart for the specified customer ID, if found; otherwise an empty Optional.
     */
    List<Cart> getCarts(String customerId);

    /**
     * Retrieves a cart for the specified customer ID, if available.
     *
     * @param cartId The ID of the customer for whom to retrieve the cart.
     * @return An Optional object containing the Cart for the specified cart ID, if found; otherwise an empty Optional.
     */
    Cart getCart(String cartId);

    /**
     * Retrieves a cart for the specified cart ID, if available.
     *
     * @param cartId     The ID of the cart to retrieve.
     * @param customerId The ID of the customer associated with the cart.
     * @return The Cart object for the specified cart ID and customer ID, if found; otherwise null.
     */
    Cart getCart(String cartId, String customerId);

    /**
     * Deletes a cart with the specified cart ID.
     *
     * @param cartId The ID of the cart to delete.
     */
    void deleteCart(String cartId);

    /**
     * Counts the total number of carts.
     *
     * @return The total number of carts.
     */
    long countAll();

    /**
     * Retrieves the count of carts for the specified customer ID, if available.
     *
     * @param customerId The ID of the customer for whom to retrieve the count of carts.
     * @return An Optional object containing the count of carts for the specified customer ID, if found; otherwise an empty Optional.
     */
    long countAll(String customerId);
}
