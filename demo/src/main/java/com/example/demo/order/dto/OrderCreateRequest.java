package com.example.demo.order.dto;

import com.example.demo.member.Member;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class OrderCreateRequest {

    private Long memberId;
    private LocalDateTime orderDate;
    private int totalPrice;
    private int pointused;
    private int cashAmount;
    private String status;

    public OrderCreateRequest(Long memberId, LocalDateTime orderDate, int totalPrice, int pointused, int cashAmount, String status){
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.pointused = pointused;
        this.cashAmount = cashAmount;
        this.status = status;
    }
}
