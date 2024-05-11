package com.app.orders_service.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.orders_service.model.Order;
import com.app.orders_service.model.OrderItems;
import com.app.orders_service.repository.OrderRepository;
import com.app.orders_service.requests.*;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final WebClient.Builder webClientBuilder;
    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest request) {

       BaseResponse response = this.webClientBuilder.build()
                    .post()
                    .uri("http://localhost:8083/demo/inventory/in-stock")
                    .bodyValue(request.getOrderItems())
                     //Send the request.getOrderItems()
                     .retrieve()
                     //We have to specify the expected response type.
                    .bodyToMono(BaseResponse.class)
                    .block();
      if(response != null && !response.hasError()){
         Order order = new Order();
         //We're going to generate a unique ID for the order
         order.setOrderNumber(UUID.randomUUID().toString());
         //set orderItems to order
         //seteamos los valores de request itemRequest a orderItems y luego a requestItems y de alli a la entidad order
         order.setOrderItems(request.getOrderItems().stream()
         .map(orderItems-> mapOrderItemRequestToOrderItem(orderItems,order))
         .toList());
          this.orderRepository.save(order);
      }else{
         throw new IllegalArgumentException("stock does´t exist");
      }
                    
   }

    public List<OrderResponse> getAllOrders(){
     //We find the values in Order 
     List<Order> orders = this.orderRepository.findAll();
        System.out.println(orders.stream().map(this::mapToOrderResponse).toList());
        return orders.stream().map(this::mapToOrderResponse).toList();
    }

   public OrderResponse mapToOrderResponse(Order order){
    return new OrderResponse(order.getId(),
    order.getOrderNumber(),
    order.getOrderItems().stream()
    //we gotta get the orderItemsResponse
    .map(this::mapToOrderItemsResponse).toList());
   }

   public OrderItemsResponse mapToOrderItemsResponse(OrderItems orderItems){
    return new OrderItemsResponse(orderItems.getId(),
      orderItems.getSku(), 
      orderItems.getPrice(),
      orderItems.getQuantity());
      
   }

   private OrderItems mapOrderItemRequestToOrderItem(OrderItemsRequest orderItemRequest, Order order) {   
   
      return OrderItems.builder()
            .id(orderItemRequest.id)
            .sku(orderItemRequest.sku)
            .price(orderItemRequest.price)
            .quantity(orderItemRequest.getQuantity())
            .order(order)
            .build();
   }

}
