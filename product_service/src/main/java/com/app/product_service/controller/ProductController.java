package com.app.product_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import com.app.product_service.requests.ProductRequest;
import com.app.product_service.requests.ProductResponse;
import com.app.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/demo/product")
public class ProductController {

    private final ProductService productService;
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllproducts(){
        return this.productService.allProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertProducts(@RequestBody ProductRequest request){
         System.out.println("agragewsdf");
          productService.addProducts(request);
    }
}
