package com.example.demo.product.service;

import com.example.demo.product.dto.ProductRequest;
import com.example.demo.product.entity.Product;

import java.util.List;

public interface ProductService {
    Long createProduct(ProductRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
}
