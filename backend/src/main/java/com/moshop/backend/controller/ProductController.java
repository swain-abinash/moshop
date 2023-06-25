package com.moshop.backend.controller;

import com.moshop.backend.model.Product;
import com.moshop.backend.services.ProductService;
import com.moshop.backend.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @PostMapping
    public void addProduct(@RequestBody Product product) {
           productServiceImpl.addProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productServiceImpl.getProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProduct(@PathVariable String productId) {
        return productServiceImpl.getProduct(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable String productId) {
        productServiceImpl.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@PathVariable String productId, @RequestBody Product product) {
        productServiceImpl.updateProduct(productId, product);
    }

    @GetMapping("/count")
    public long countAll() {
        return productServiceImpl.countAll();
    }

    @GetMapping("/active")
    public List<Product> getActiveProduct() {
        return productServiceImpl.getActiveProducts();
    }
}
