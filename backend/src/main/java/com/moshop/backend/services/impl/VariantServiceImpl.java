package com.moshop.backend.services.impl;

import com.moshop.backend.model.dto.VariantRequestDTO;
import com.moshop.backend.model.entity.Variant;
import com.moshop.backend.repository.VariantRepository;
import com.moshop.backend.services.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VariantServiceImpl implements VariantService {
    private final VariantRepository variantRepository;

    @Override
    public void addVariant(VariantRequestDTO variantRequestDTO) {
        var variant = new Variant();

        BeanUtils.copyProperties(variantRequestDTO, variant);

        variant.setCreatedDate(LocalDateTime.now());
        variant.setUpdatedDate(LocalDateTime.now());
        variant.setActive(true);

        variantRepository.insert(variant);
    }

    @Override
    public List<Variant> getVariants() {
        return variantRepository.findAll();
    }

    @Override
    public Optional<Variant> getVariant(String variantId) {
        return variantRepository.findById(variantId);
    }

    @Override
    public void deleteVariant(String variantId) {
        var variant = getVariant(variantId).orElseThrow();

        variant.setActive(false);
        variant.setUpdatedDate(LocalDateTime.now());

        variantRepository.save(variant);
    }

    @Override
    public void updateVariant(String variantId, VariantRequestDTO variantRequestDTO) {
        var variant = getVariant(variantId).orElseThrow();

        BeanUtils.copyProperties(variantRequestDTO, variant);

        variant.setUpdatedDate(LocalDateTime.now());

        variantRepository.save(variant);
    }

    @Override
    public long countAll() {
        return variantRepository.count();
    }

    @Override
    public List<Variant> getActiveVariants() {
        return variantRepository.findAllByIsActive(true);
    }
}
