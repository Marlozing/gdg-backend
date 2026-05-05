package com.example.demo.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long productId;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private int productPrice;

    @Column(name="product_stock")
    private int productStock;

    public Product(String productName, int productPrice, int productStock) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
    }

    public void updateInfo(String productName, int productPrice, int productStock){
        if (productName!=null) this.productName = productName;
        if (productPrice!=0) this.productPrice = productPrice;
        if(productStock!=0) this.productStock = productStock;
    }
}
