package com.app.notification_Service.listener;

import com.app.notification_Service.events.OrdersEvent;
import com.app.notification_Service.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderEventListener {

    @KafkaListener(topics = "orders-topic")
    public void handlerOrderNotifications(String message){
        var orderEvent = JsonUtils.fromJson(message, OrdersEvent.class);
        log.info("Error {} event received for order: {} with {} items",orderEvent.orderStatus(),orderEvent.orderNumbers(),orderEvent.iItemCount());
    }
}
