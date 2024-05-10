package com.example.stationstd22082.service;

import com.example.stationstd22082.model.Product;
import com.example.stationstd22082.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getListOfProduct() {
        try {
            return productRepository.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Product getProductById(String id) {
        try {
            return productRepository.getProductById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Product createProduct(Product product) {
        try {
            return productRepository.createProduct(product);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Product updateProduct(Product product) {
        try {
            return productRepository.updateProduct(product);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Product deleteProduct(String id) {
        try {
            productRepository.deleteProduct(productRepository.getProductById(id));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }
}



