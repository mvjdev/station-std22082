package com.example.stationstd22082.controller;

import com.example.stationstd22082.model.Product;
import com.example.stationstd22082.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getProducts() {
        return productService.getListOfProduct();
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }
}
