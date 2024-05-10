package com.example.stationstd22082.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductTemplate implements Serializable {
    private String id;
    private String name;
    private BigDecimal price;
    private Double stockQuantity;
}
