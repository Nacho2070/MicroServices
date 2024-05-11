package com.app.invetory_service.controllers;

import com.app.invetory_service.dto.BaseResponse;
import com.app.invetory_service.dto.OrderItemsRequest;
import com.app.invetory_service.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/demo/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku") String sku){
        return inventoryService.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse areInStock(@RequestBody List<OrderItemsRequest> orderItemsRequests){
        return inventoryService.areInStock(orderItemsRequests);
    }
}
