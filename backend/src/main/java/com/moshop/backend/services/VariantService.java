package com.moshop.backend.services;

import com.moshop.backend.model.dto.VariantRequestDTO;
import com.moshop.backend.model.entity.Variant;

import java.util.List;
import java.util.Optional;

public interface VariantService {
    /**
     * <h3>Adds a variant based on the provided VariantRequestDTO.<h3>
     *
     * @param variantRequestDTO The VariantRequestDTO object containing the details of the variant to be added.
     */
    void addVariant(VariantRequestDTO variantRequestDTO);

    /**
     * <h3>Retrieves a list of variants.<h3>
     *
     * @return A list of Variant objects representing the available variants.
     */
    List<Variant> getVariants();

    /**
     *<h3> Retrieves a variant with the specified ID.<h3>
     *
     * @param variantId The ID of the variant to retrieve.
     * @return An Optional containing the Variant object if found, or an empty Optional if not found.
     */
    Optional<Variant> getVariant(String variantId);

    /**
     *<h3> Deletes a variant identified by the given variant ID.<h3>
     *
     * @param variantId The ID of the variant to be deleted.
     */
    void deleteVariant(String variantId);

    /**
     *<h3> Updates an existing variant with the provided information.<h3>
     *
     * @param variantId      The ID of the variant to be updated.
     * @param variantRequestDTO The updated Variant object containing the new information.
     */
    void updateVariant(String variantId, VariantRequestDTO variantRequestDTO);

    /**
     *<h3> Counts the total number of variants.<h3>
     *
     * @return The total number of variants as a long value.
     */
    long countAll();

    /**
     * <h3>Retrieves a list of active variants.</h3>
     *
     * @return A list of Variant objects representing the active variants.
     */
    List<Variant> getActiveVariants();
}
