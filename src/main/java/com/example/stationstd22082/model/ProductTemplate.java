package com.example.stationstd22082.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTemplate {
    private String id;
    private String name;
    private BigDecimal price;
}
