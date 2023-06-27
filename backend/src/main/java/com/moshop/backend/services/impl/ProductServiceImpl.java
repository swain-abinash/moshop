package com.moshop.backend.services.impl;

import com.moshop.backend.model.dto.ProductRequestDTO;
import com.moshop.backend.model.entity.Product;
import com.moshop.backend.repository.ProductRepository;
import com.moshop.backend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void addProduct(ProductRequestDTO productRequestDTO) {
        var product = new Product();

        BeanUtils.copyProperties(productRequestDTO, product);
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
        var product = getProduct(productId).orElseThrow();
        product.setActive(false);

        productRepository.save(product);
    }

    @Override
    public void updateProduct(String productId, ProductRequestDTO productRequestDTO) {
        var optionalProduct = getProduct(productId);
        var updateProduct = optionalProduct.get();

        updateProduct.setProductName(productRequestDTO.getProductName());
        updateProduct.setProductPrice(productRequestDTO.getProductPrice());
        updateProduct.setProductDescription(productRequestDTO.getProductDescription());
        updateProduct.setProductImage(productRequestDTO.getProductImage());
        updateProduct.setUpdatedDate(LocalDateTime.now());

        productRepository.save(updateProduct);
    }

    @Override
    public long countAll() {
        return productRepository.count();
    }

    @Override
    public List<Product> getActiveProducts() {
        return productRepository.findAllByIsActive(true);
    }
}
