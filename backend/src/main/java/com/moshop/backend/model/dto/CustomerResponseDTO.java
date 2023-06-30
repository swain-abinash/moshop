package com.moshop.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerNumber;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isActive;
}
