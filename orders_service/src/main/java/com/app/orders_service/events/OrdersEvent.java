package com.app.orders_service.events;

import com.app.orders_service.model.enums.OrderStatus;

public record OrdersEvent(String orderNumbers, int ItemCount, OrderStatus orderStatus) {
}
