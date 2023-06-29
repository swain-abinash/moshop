package com.moshop.backend.services;

import com.moshop.backend.model.dto.ProductRequestDTO;
import com.moshop.backend.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    /**
     * <h3>Adds a new product based on the provided ProductRequestDTO.</h3>
     *
     * @param productRequestDTO The ProductRequestDTO object containing the details of the product to be added.
     */
    void addProduct(ProductRequestDTO productRequestDTO);

    /**
     * Retrieves a list of products.
     *
     * @return A list of Product objects representing the available products.
     */
    List<Product> getProducts();

    /**
     * Retrieves a product with the specified ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return An Optional containing the Product object if found, or an empty Optional if not found.
     */
    Optional<Product> getProduct(String productId);

    /**
     * Deletes a product identified by the given product ID.
     *
     * @param productId The ID of the product to be deleted.
     */
    void deleteProduct(String productId);

    /**
     * Updates an existing product with the provided information.
     *
     * @param productId         The ID of the product to be updated.
     * @param productRequestDTO The updated ProductRequestDTO containing the new information.
     */
    void updateProduct(String productId, ProductRequestDTO productRequestDTO);

    /**
     * Counts the total number of products.
     *
     * @return The total number of products as a long value.
     */
    long countAll();

    /**
     * Retrieves a list of active products.
     *
     * @return A list of Product objects representing the active products.
     */
    List<Product> getActiveProducts();
}
