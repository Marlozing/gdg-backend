package com.example.demo.order.dto;

import lombok.Getter;

@Getter
public class OrderCreateRequest {
    private String orderId;

    public OrderCreateRequest(String productId){
        this.orderId = productId;
    }
}
