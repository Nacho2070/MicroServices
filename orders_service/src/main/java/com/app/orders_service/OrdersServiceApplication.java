package com.app.orders_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication
public class OrdersServiceApplication {
    @LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(OrdersServiceApplication.class, args);
	}

}
