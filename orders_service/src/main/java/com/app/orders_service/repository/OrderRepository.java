package com.app.orders_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.orders_service.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
