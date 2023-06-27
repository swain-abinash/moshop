package com.moshop.backend.controller;

import com.moshop.backend.model.dto.CartRequestDTO;
import com.moshop.backend.model.entity.Cart;
import com.moshop.backend.services.impl.CartServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartServiceImpl;


    @PostMapping("/{customerId}")
    public ResponseEntity<Void> createCart(@PathVariable String customerId, @RequestBody CartRequestDTO cartRequestDTO) {
        cartServiceImpl.createCart(customerId, cartRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCarts() {
        List<Cart> carts = cartServiceImpl.getCarts();
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCarts(@PathVariable String customerId) {
        List<Cart> carts = cartServiceImpl.getCarts(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {
        Cart cart = cartServiceImpl.getCart(cartId);
        if (cart != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{cartId}/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId, @PathVariable String customerId) {
        Cart cart = cartServiceImpl.getCart(cartId, customerId);
        if (cart != null) {
            return ResponseEntity.status(HttpStatus.OK).body(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        cartServiceImpl.deleteCart(cartId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        long count = cartServiceImpl.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/count/{customerId}")
    public ResponseEntity<Long> countAll(@PathVariable String customerId) {
        long count = cartServiceImpl.countAll(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
}