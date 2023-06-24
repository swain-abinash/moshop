package com.moshop.backend.services;

import com.moshop.backend.model.Variant;

import java.util.List;
import java.util.Optional;

/**
 * <h1>save Variant in to DB</h1>
 * <p>this method take Variant as parameter and save it into database.</p>
 *
 * @Param com.moshop.backend.model.Variant
 */

public interface VariantService {
    void addVariant(Variant variant);

    List<Variant> getVariants();

    Optional<Variant> getVariant(String id);

    void deleteVariant(String Variant);

    void updateVariant(String id, Variant variant);

    long countAll();

    List<Variant> getActiveVariant();

}
