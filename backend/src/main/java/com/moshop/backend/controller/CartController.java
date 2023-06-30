package com.moshop.backend.controller;

import com.moshop.backend.model.dto.CartRequestDTO;
import com.moshop.backend.model.entity.Cart;
import com.moshop.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Void> createCart(@PathVariable String customerId, @RequestBody CartRequestDTO cartRequestDTO) {
        cartService.createCart(customerId, cartRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cart>> getCarts() {
        List<Cart> carts = cartService.getCarts();
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCarts(@PathVariable String customerId) {
        List<Cart> carts = cartService.getCarts(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId) {
        Cart cart = cartService.getCart(cartId).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @GetMapping("/{cartId}/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable String cartId, @PathVariable String customerId) {
        Cart cart = cartService.getCart(cartId, customerId).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(cart);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        long count = cartService.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/count/{customerId}")
    public ResponseEntity<Long> countAll(@PathVariable String customerId) {
        long count = cartService.countAll(customerId);
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }
}