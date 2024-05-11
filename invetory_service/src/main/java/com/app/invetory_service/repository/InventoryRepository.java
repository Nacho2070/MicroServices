package com.app.invetory_service.repository;

import com.app.invetory_service.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository  extends JpaRepository<Inventory,Long> {

    Optional<Inventory> findBySku(String sku);

    List<Inventory> findBySkuIn(List<String> skus);

}
