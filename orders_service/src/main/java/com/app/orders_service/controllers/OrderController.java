package com.app.orders_service.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.orders_service.requests.OrderRequest;
import com.app.orders_service.requests.OrderResponse;
import com.app.orders_service.services.OrderService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("demo/orders")
public class OrderController {
    
    private final OrderService orderService;  
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void placeOrder(@RequestBody OrderRequest request){
     this.orderService.placeOrder(request);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getOrder(){
      return this.orderService.getAllOrders();
    }
}
