package com.example.stationstd22082.controller;

import com.example.stationstd22082.model.ProductTemplate;
import com.example.stationstd22082.service.ProductTemplateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductTemplateController {
    private final ProductTemplateService productTemplateService;

    @GetMapping("/product/template")
    public List<ProductTemplate> getProductTemplate() {
            return productTemplateService.getListOfProductTemplate();
    }

    @GetMapping("/product/template/{id}")
    public ProductTemplate getProductTemplateById(@PathVariable String id) {
        return productTemplateService.getProductTemplateById(id);
    }

    @PostMapping("/product/template")
    public ProductTemplate createProductTemplate(@RequestBody ProductTemplate productTemplate) {
        return productTemplateService.createProductTemplate(productTemplate);
    }

    @PutMapping("/product/template")
    public ProductTemplate updateProductTemplate(@RequestBody ProductTemplate productTemplate) {
        return productTemplateService.updateProductTemplate(productTemplate);
    }

    @DeleteMapping("/product/template/{id}")
    public void deleteProductTemplate(@PathVariable String id) {
        productTemplateService.deleteProductTemplate(id);
    }
}
