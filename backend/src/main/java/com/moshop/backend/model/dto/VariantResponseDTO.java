package com.moshop.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariantResponseDTO {
    private String variantId;
    private String variantName;
    private String variantImage;
    private String variantDescription;
}