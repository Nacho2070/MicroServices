package com.app.notification_Service.events;

import com.app.notification_Service.modelEnum.OrderStatus;

public record OrdersEvent(String orderNumbers, int iItemCount, OrderStatus orderStatus) {
}
