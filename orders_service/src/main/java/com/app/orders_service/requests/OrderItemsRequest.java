package com.app.orders_service.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * OrderItemsRequest
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
 public class OrderItemsRequest {
    public Long id;
    public String sku;
    public Double price;
    public Long quantity;
}