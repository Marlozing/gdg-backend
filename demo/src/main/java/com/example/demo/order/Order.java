package com.example.demo.order;

import com.example.demo.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name="point_used")
    private int pointused;

    @Column(name="cash_amount")
    private int cashAmount;

    @Column(name = "status", length = 251)
    private String status;

    public Order(Member member, LocalDateTime orderDate, int totalPrice, int pointused, int cashAmount, String status) {
        this.member = member;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.pointused = pointused;
        this.cashAmount = cashAmount;
        this.status = status;
    }

    public void updateInfo(Member member, LocalDateTime orderDate, int totalPrice, int pointused, int cashAmount, String status){
        if (member!=null) this.member = member;
        if (orderDate!=null) this.orderDate = orderDate;
        if (totalPrice!=0) this.totalPrice = totalPrice;
        if (pointused!=0) this.pointused = pointused;
        if (cashAmount!=0) this.cashAmount = cashAmount;
        if (status!=null) this.status = status;

    }

}
