package com.moshop.backend.services.impl;

import com.moshop.backend.model.dto.CartRequestDTO;
import com.moshop.backend.model.entity.Cart;
import com.moshop.backend.repository.CartRepository;
import com.moshop.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Override
    public void createCart(String customerId, CartRequestDTO cartRequestDTO) {
        var cart = new Cart();

        BeanUtils.copyProperties(cartRequestDTO, cart);

        cart.setCreatedDate(LocalDateTime.now());
        cart.setUpdatedDate(LocalDateTime.now());
        cart.setActive(true);
        cart.setCustomerId(customerId);

        cartRepository.insert(cart);
    }

    @Override
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    @Override
    public List<Cart> getCarts(String customerId) {
        return cartRepository.findAllByCustomerId(customerId);
    }

    @Override
    public Optional<Cart> getCart(String cartId) {
        return cartRepository.findById(cartId);
    }

    @Override
    public Optional<Cart> getCart(String cartId, String customerId) {
        return Optional.ofNullable(cartRepository.findByCartIdAndCustomerId(cartId, customerId));
    }

    @Override
    public void deleteCart(String cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow();

        cart.setActive(false);
        cart.setUpdatedDate(LocalDateTime.now());

        cartRepository.save(cart);
    }

    @Override
    public long countAll() {
        return cartRepository.count();
    }

    @Override
    public long countAll(String customerId) {
        return cartRepository.countByCustomerId(customerId);
    }
}