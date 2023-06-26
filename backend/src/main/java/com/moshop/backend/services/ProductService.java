package com.moshop.backend.services;

import com.moshop.backend.model.dto.ProductRequestDTO;
import com.moshop.backend.model.dto.ProductResponseDTO;
import com.moshop.backend.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /**
     * <h1>Save Product into DB</h1>
     * <p>This method take product object
     * as parameter and save it into Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    void addProduct(ProductRequestDTO productRequestDTO);

    /**
     * <h1>Getting all products</h1>
     * <p>This method retrieve all
     *  products from Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    List<Product> getProducts();

    /**
     * <h1>Getting single product</h1>
     * <p>This method retrieve single
     *  product from Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    Optional<Product> getProduct(String productId);

    /**
     * <h1>Delete single product</h1>
     * <p>This method  delete single
     *  product from Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    void deleteProduct(String productId);

    /**
     * <h1>Update products</h1>
     * <p>This method update
     *  products from Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    void updateProduct(String productId, Product product);

    /**
     * <h1>Count all products</h1>
     * <p>This method count all
     *  products from Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    long countAll();

    /**
     * <h1>Product active or not</h1>
     * <p>This method tells if the product is
     *  active or not in the Database
     * </p>
     *
     * @param com.moshop.backend.model.Product
     */
    List<Product> getActiveProducts();
}
