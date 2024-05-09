package com.example.stationstd22082.service;

import com.example.stationstd22082.model.ProductTemplate;
import com.example.stationstd22082.repository.ProductTemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductTemplateService {
    private final ProductTemplateRepository productTemplateRepository;

    public List<ProductTemplate> getListOfProductTemplate() {
        try {
            return productTemplateRepository.getAll();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProductTemplate getProductTemplateById(String id) {
        try {
            return productTemplateRepository.getProductTemplateById(id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProductTemplate createProductTemplate(ProductTemplate productTemplate) {
        try {
            return productTemplateRepository.createProductTemplate(productTemplate);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProductTemplate updateProductTemplate(ProductTemplate productTemplate) {
        try {
            return productTemplateRepository.updateProductTemplate(productTemplate);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public ProductTemplate deleteProductTemplate(String id) {
        try{
            productTemplateRepository.deleteProductTemplate(productTemplateRepository.getProductTemplateById(id));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return null;
    }

}
