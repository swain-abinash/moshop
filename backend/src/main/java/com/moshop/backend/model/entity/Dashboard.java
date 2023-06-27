package com.moshop.backend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dashboard {
    private long totalVariants;
    private long totalProducts;
    private long totalCustomers;
    private long totalCarts;
    private long totalOrders;
}
