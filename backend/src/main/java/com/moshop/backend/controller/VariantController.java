package com.moshop.backend.controller;

import com.moshop.backend.model.Variant;
import com.moshop.backend.services.VariantService;
import com.moshop.backend.services.impl.VariantServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/variant")
@RequiredArgsConstructor
public class VariantController {
    private final VariantServiceImpl variantServiceImpl;


    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody Variant variant) {
        variantServiceImpl.addVariant(variant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Variant>> getVariants() {
        var variants = variantServiceImpl.getVariants();

        if (variants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(variants);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(variants);
        }
    }

    @GetMapping({"/variantId"})
    public ResponseEntity<Variant> getProduct(@PathVariable String variantId) {
        var product = variantServiceImpl.getVariant(variantId);

        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus
                    .OK).body(product.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping({"/variantId"})
    public void deleteVariant(@RequestParam String variantId) {
        variantServiceImpl.deleteVariant(variantId);
    }

    @PutMapping({"/variantId"})
    public void updatevariant(@PathVariable String id, @RequestBody Variant variant) {
        variantServiceImpl.updateVariant(id, variant);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countAll() {
        var count = variantServiceImpl.countAll();
        return ResponseEntity.status(HttpStatus.OK).body(count);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Variant>> getActiveProduct() {
        var variants = variantServiceImpl.getActiveVariant();

        if (!variants.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(variants);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}

