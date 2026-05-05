package com.example.demo.product.dto;

import lombok.Getter;

@Getter
public class ProductUpdateRequest {
    private String productName;
    private int productPrice;
    private int productStock;

    public ProductUpdateRequest(String productName, int productPrice, int productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }
}
