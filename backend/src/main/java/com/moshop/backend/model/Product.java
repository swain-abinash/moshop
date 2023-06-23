package com.moshop.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document

public class Product {
    @Id
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private String variantId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isActive;

}
