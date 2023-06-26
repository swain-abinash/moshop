package com.moshop.backend.model.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VariantRequestDTO {
    private String variantName;
    private String variantId;
    private  String variantDescrption;
}
