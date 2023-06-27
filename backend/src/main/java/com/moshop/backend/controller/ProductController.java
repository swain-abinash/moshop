package com.moshop.backend.controller;

import com.moshop.backend.model.dto.ProductRequestDTO;
import com.moshop.backend.model.entity.Product;
import com.moshop.backend.services.ProductService;
import com.moshop.backend.services.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody ProductRequestDTO productRequestDTO) {
           productService.addProduct(productRequestDTO);
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping
    public  ResponseEntity<List<Product>> getProducts() {
        var products = productService.getProducts();

        if (products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(products);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        var product = productService.getProduct(productId);

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable String productId, @RequestBody ProductRequestDTO productRequestDTO) {
        productService.updateProduct(productId, productRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        var count = productService.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Product>> getActiveProduct() {
        var products = productService.getActiveProducts();

        if (!products.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(products);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
