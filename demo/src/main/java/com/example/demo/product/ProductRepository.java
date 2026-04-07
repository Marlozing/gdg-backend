package com.example.demo.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager em;

    public Product findById(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        return em.createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public Product findByLoginId(String productId){
        List<Product> result = em.createQuery(
                "Select p FROM Product p WHERE p.productId = :productId", Product.class
        ).setParameter("productId", productId).getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Product product){
        return em.persist(product);
    }

    public void deleteById(Long id){
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
}
