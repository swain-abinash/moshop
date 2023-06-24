package com.moshop.backend.services.impl;

import com.moshop.backend.model.Cart;
import com.moshop.backend.repository.CartRepository;
import com.moshop.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    @Override
    public void createCart(String customerId, Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> getCarts(String customerId) {
        return cartRepository.findAllByCustomerId(customerId);
    }


    @Override
    public Cart getCart(String cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public Cart getCart(String cartId, String customerId) {
        return null;
    }

    @Override
    public void deleteCart(String cartId) {
     cartRepository.deleteById(cartId);
    }

    @Override
    public void updateCart(String customerId, Cart cart) {

    }

    @Override
    public long countAll() {
        return 0;
    }

    @Override
    public long countAll(String customerId) {
        return 0;
    }
}
