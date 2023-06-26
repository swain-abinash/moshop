package com.moshop.backend.services.impl;

import com.moshop.backend.model.Product;
import com.moshop.backend.repository.ProductRepository;
import com.moshop.backend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.insert(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProduct(String productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.delete(false);
    }

    @Override
    public void updateProduct(String productId, Product product) {
        var optionalProduct = getProduct(productId);
        var updateProduct = optionalProduct.get();

        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductPrice(product.getProductPrice());
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProductImage(product.getProductImage());
        updateProduct.setVariantId(product.getVariantId());
        updateProduct.setUpdatedDate(LocalDateTime.now());

        productRepository.save(product);
    }

    @Override
    public long countAll() {
        return productRepository.count();
    }

    @Override
    public List<Product> getActiveProducts() {
        return productRepository.findAllByIsActiveProduct(true);
    }
}
