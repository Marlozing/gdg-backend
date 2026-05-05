package com.example.demo.orderedProduct;

import com.example.demo.order.Order;
import com.example.demo.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ordered_products")
@Getter
@NoArgsConstructor
public class orderedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ordered_product_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;

    public orderedProduct(Order order, Product product){
        this.order = order;
        this.product = product;
    }
}
