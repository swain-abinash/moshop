package com.moshop.backend.services;

import com.moshop.backend.model.dto.VariantRequestDTO;
import com.moshop.backend.model.entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
    /**
     * Adds a variant based on the provided VariantRequestDTO.
     *
     * @param variantRequestDTO The VariantRequestDTO object containing the details of the variant to be added.
     */
    void addVariant(VariantRequestDTO variantRequestDTO);

    /**
     * Retrieves a list of variants.
     *
     * @return A list of Variant objects representing the available variants.
     */
    List<Variant> getVariants();

    /**
     * Retrieves a variant with the specified ID.
     *
     * @param variantId The ID of the variant to retrieve.
     * @return An Optional containing the Variant object if found, or an empty Optional if not found.
     */
    Optional<Variant> getVariant(String variantId);

    /**
     * Deletes a variant identified by the given variant ID.
     *
     * @param variantId The ID of the variant to be deleted.
     */
    void deleteVariant(String variantId);

    /**
     * Updates an existing variant with the provided information.
     *
     * @param variantId      The ID of the variant to be updated.
     * @param variantRequestDTO The updated Variant object containing the new information.
     */
    void updateVariant(String variantId, VariantRequestDTO variantRequestDTO);

    /**
     * Counts the total number of variants.
     *
     * @return The total number of variants as a long value.
     */
    long countAll();

    /**
     * Retrieves a list of active variants.
     *
     * @return A list of Variant objects representing the active variants.
     */
    List<Variant> getActiveVariants();
}
