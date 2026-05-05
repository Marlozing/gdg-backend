package com.example.demo.product;


import com.example.demo.product.dto.ProductCreateRequest;
import com.example.demo.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long createProduct(ProductCreateRequest request) {
        /*
        Product existingMember = productRepository.findByProductId(request.getProductId());
        if (existingMember != null) {
            throw new RuntimeException("이미 존재하는 상품입니다: " + request.getProductId());
        }
        */
        Product product = new Product(
                request.getProductName(),
                request.getProductPrice(),
                request.getProductStock()
        );

        productRepository.save(product);

        return product.getProductId();
    }

    @Transactional(readOnly=true)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Transactional(readOnly=true)
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        return product;
    }

    @Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
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

    @Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        productRepository.deleteById(id);
    }
}
