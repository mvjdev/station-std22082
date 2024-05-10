package com.example.stationstd22082.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationStock {
    private String id;
    private String idProduct;
    private BigDecimal quantity;
    private Instant dateTime;
    private String type;
}
