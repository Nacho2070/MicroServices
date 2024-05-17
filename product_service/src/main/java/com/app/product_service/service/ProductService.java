package com.app.product_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.product_service.model.entities.Product;
import com.app.product_service.repository.ProductRepository;
import com.app.product_service.requests.ProductRequest;
import com.app.product_service.requests.ProductResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
 
    private final ProductRepository repository;

  public void addProducts(ProductRequest request){
    var productObj = Product.builder()
    .sku(request.getSku())
    .name(request.getName())
    .description(request.getDescription())
    .price(request.getPrice())
    .status(request.getStatus())
    .build();
    repository.save(productObj);
    log.info("Product added: {}", productObj);
  }

  public List<ProductResponse> allProducts(){
    var products = repository.findAll();
    return products.stream().map(this::mapToProductResponse).collect(Collectors.toList());
  }

  private ProductResponse mapToProductResponse(Product product){
       
    return ProductResponse.builder()
           .id(product.getId())
           .sku(product.getSku())
           .name(product.getName())
           .description(product.getDescription())
           .price(product.getPrice())
           .status(product.getStatus())
           .build();
  }

}
