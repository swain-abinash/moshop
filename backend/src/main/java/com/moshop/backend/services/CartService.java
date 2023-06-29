package com.moshop.backend.services;

import com.moshop.backend.model.dto.CartRequestDTO;
import com.moshop.backend.model.entity.Cart;

import java.util.List;
import java.util.Optional;


public interface CartService {
    /**
     *<h3> Creates a new cart for the specified customer.</h3>
     *
     * @param customerId The ID of the customer for whom the cart is being created.
     * @param cartRequestDTO The Cart object representing the cart to be created.
     */
    void createCart(String customerId, CartRequestDTO cartRequestDTO);

    /**
     *<h3> Retrieves a list of carts.</h3>
     *
     * @return A list of Cart objects representing the available carts.
     */
    List<Cart> getCarts();

    /**
     * <h3>Retrieves a cart for the specified customer ID, if available.</h3>
     *
     * @param customerId The ID of the customer for whom to retrieve the cart.
     * @return An Optional object containing the Cart for the specified customer ID, if found; otherwise an empty Optional.
     */
    List<Cart> getCarts(String customerId);

    /**
     * <h3>Retrieves a cart for the specified customer ID, if available.</h3>
     *
     * @param cartId The ID of the customer for whom to retrieve the cart.
     * @return An Optional object containing the Cart for the specified cart ID, if found; otherwise an empty Optional.
     */
    Optional<Cart> getCart(String cartId);

    /**
     *<h3> Retrieves a cart for the specified cart ID, if available.</h3>
     *
     * @param cartId     The ID of the cart to retrieve.
     * @param customerId The ID of the customer associated with the cart.
     * @return The Cart object for the specified cart ID and customer ID, if found; otherwise null.
     */
    Optional<Cart> getCart(String cartId, String customerId);

    /**
     *<h3> Deletes a cart with the specified cart ID.</h3>
     *
     * @param cartId The ID of the cart to delete.
     */
    void deleteCart(String cartId);

    /**
     * <h3>Counts the total number of carts.</h3>
     *
     * @return The total number of carts.
     */
    long countAll();

    /**
     * <h3>Retrieves the count of carts for the specified customer ID, if available.<h3>
     *
     * @param customerId The ID of the customer for whom to retrieve the count of carts.
     * @return An Optional object containing the count of carts for the specified customer ID, if found; otherwise an empty Optional.
     */
    long countAll(String customerId);
}
