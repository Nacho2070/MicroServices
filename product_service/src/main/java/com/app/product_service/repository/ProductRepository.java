package com.app.product_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.app.product_service.model.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
