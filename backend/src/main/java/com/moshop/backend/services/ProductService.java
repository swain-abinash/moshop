package com.moshop.backend.services;

import com.moshop.backend.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /**
     * <h1>Save Employee into DB</h1>
     * <p>This method take employee object
     * as parameter and save it into Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    void addProduct(Product product);

    List<Product> getProducts();

    Optional<Product> getProduct(String productId);

    void deleteProduct(String productId);

    void updateProduct(String productId, Product product);

    long countAll();

    List<Product> getActiveProducts();

}
