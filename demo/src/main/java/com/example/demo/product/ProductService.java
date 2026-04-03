package com.example.demo.product;




import com.example.demo.product.dto.ProductCreateRequest;
import com.example.demo.product.dto.ProductUpdateRequest;

import java.util.List;

public class ProductService {

    private final ProductResposity productResposity;

    //@Transactional
    public Long createMember(ProductCreateRequest request) {
        Product existingMember = productResposity.findByProductId(request.);
        if (existingMember != null) {
            throw new RuntimeException("이미 존재하는 상품입니다: " + request.getProductId());
        }

        Product product = new Product(
                request.getProductId()
        );

        productRepository.save(product);

        return product.getId();
    }

    //@Transactional(readOnly=True)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    //@Transactional(readOnly=True)
    public Product getProductById(Long id) {
        Product product = productResposity.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        return product;
    }

    //@Transactional
    public void updateProduct(Long id, ProductUpdateRequest request){
        Product product = productResposity.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        product.updateInfo();
    }

    //@Transactional
    public void deleteProduct(Long id){
        Product product = productRepository.findById(id);

        if (product == null){
            throw new RuntimeException("상품을 찾을 수 없습니다");
        }

        productResposity.deleteById(id);
    }
}
