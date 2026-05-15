package com.example.demo.product.service;


import com.example.demo.product.dto.ProductRequest;
import com.example.demo.product.entity.Product;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Long createProduct(ProductRequest request) {
        Product product = new Product(
                request.getProductName(),
                request.getProductPrice(),
                request.getProductStock()
        );

        productRepository.save(product);

        return product.getProductId();
    }

    @Override
    @Transactional(readOnly=true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        return product;
    }

    @Override
    @Transactional
    public void updateProduct(Long id, ProductRequest request){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        product.updateInfo(
                request.getProductName(),
                request.getProductPrice(),
                request.getProductStock()
        );
    }

    @Override
    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        productRepository.deleteById(id);
    }
}
