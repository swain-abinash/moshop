package com.moshop.backend.services;

import com.moshop.backend.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
    void createCart(String customerId, Cart cart);
    List<Cart> getCarts();
    Optional<Cart> getCarts(String customerId);
    Cart getCart(String cartId);
    Cart getCart( String cartId,String customerId);
    void  deleteCart(String cartId);
    void updateCart(String customerId, Cart cart);
    long countAll();
    long countAll(String customerId);
}
