package com.moshop.backend.services.impl;

import com.moshop.backend.model.entity.Variant;
import com.moshop.backend.repository.VariantRepository;
import com.moshop.backend.services.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VariantServiceImpl implements VariantService {
    private final VariantRepository variantRepository;

    @Override
    public void addVariant(Variant variant) {
        variantRepository.insert(variant);
    }

    @Override
    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

    @Override
    public Optional<Variant> getVariant(String id) {
        return variantRepository.findById(id);
    }

    @Override
    public void deleteVariant(String Variant) {
        var variant = getVariant(Variant).orElseThrow();
        variant.setActive(false);

        variantRepository.save(variant);
    }

    @Override
    public void updateVariant(String id, Variant variant) {
        variantRepository.save(variant);
    }

    @Override
    public long countAll() {
        return variantRepository.count();
    }

    @Override
    public List<Variant> getActiveVariant() {
        return variantRepository.findAllByIsActive(true);
    }
}
