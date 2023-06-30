package com.moshop.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDTO {
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private String variantId;
}
