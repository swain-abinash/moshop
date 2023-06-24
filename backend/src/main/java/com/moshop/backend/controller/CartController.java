package com.moshop.backend.controller;

import com.moshop.backend.model.Cart;
import com.moshop.backend.services.impl.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartServiceImpl;

    @PostMapping("/{customerId}")
    public void createCart(@PathVariable String customerId, @RequestBody Cart cart) {
        cartServiceImpl.createCart(customerId, cart);
    }

    @GetMapping
    public List<Cart> getCarts() {
        return cartServiceImpl.getCarts();
    }

    @GetMapping("/{customerId}")
    public List<Cart> getCarts(@PathVariable String customerId) {
        return cartServiceImpl.getCarts(customerId);
    }

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable String cartId) {
        return cartServiceImpl.getCart(cartId);
    }

    @GetMapping("/{cartId}/{customerId}")
    public Cart getCart(@PathVariable String cartId, @PathVariable String customerId) {
        return cartServiceImpl.getCart(cartId, customerId);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable String cartId) {
        cartServiceImpl.deleteCart(cartId);
    }

    @GetMapping("/count")
    public long countAll() {
        return cartServiceImpl.countAll();
    }

    @GetMapping("/count/{customerId}")
    public long countAll(@PathVariable String customerId) {
        return cartServiceImpl.countAll(customerId);
    }
}