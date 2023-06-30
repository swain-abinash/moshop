package com.moshop.backend.controller;

import com.moshop.backend.model.dto.VariantRequestDTO;
import com.moshop.backend.model.entity.Variant;
import com.moshop.backend.services.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/variant")
@CrossOrigin
@RequiredArgsConstructor
public class VariantController {
    private final VariantService variantService;

    @PostMapping
    public ResponseEntity<Void> addVariant(@RequestBody VariantRequestDTO variantRequestDTO) {
        variantService.addVariant(variantRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Variant>> getVariants() {
        var variants = variantService.getVariants();

        if (!variants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(variants);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(variants);
        }
    }

    @GetMapping("/{variantId}")
    public ResponseEntity<Variant> getVariant(@PathVariable String variantId) {
        var variant = variantService.getVariant(variantId).orElseThrow();
        return ResponseEntity.status(HttpStatus.OK).body(variant);
    }

    @DeleteMapping("/{variantId}")
    public ResponseEntity<Void> deleteVariant(@PathVariable String variantId) {
        variantService.deleteVariant(variantId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{variantId}")
    public ResponseEntity<Void> updateVariant(@PathVariable String variantId, @RequestBody VariantRequestDTO variantRequestDTO) {
        variantService.updateVariant(variantId, variantRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        var count = variantService.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Variant>> getActiveVariants() {
        var variants = variantService.getActiveVariants();

        if (!variants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(variants);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}

