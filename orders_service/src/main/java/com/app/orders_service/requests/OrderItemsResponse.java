package com.app.orders_service.requests;


/**
 * OrderItemsResponse
 */
public record OrderItemsResponse(Long id,String sku,Double price,Long quantity) {
}