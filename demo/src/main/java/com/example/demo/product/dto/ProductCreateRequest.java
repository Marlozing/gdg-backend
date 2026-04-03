package com.example.demo.product.dto;

import lombok.Getter;

@Getter
public class ProductCreateRequest {
    private String productId;

    public ProductCreateRequest(String productId){
        this.productId = productId;
    }
}
