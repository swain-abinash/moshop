package com.moshop.backend.model.dto;

import java.time.LocalDateTime;

public class CustomerResponseDTO {
    private String customerName;
    private String customerAddress;
    private String customerEmail;
    private String customerNumber;
    private String customerPassword;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isActive;
}
