package com.example.stationstd22082.controller;

import com.example.stationstd22082.model.OperationStock;
import com.example.stationstd22082.service.OperationStockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperationStockController {
    private final OperationStockService operationStockService;

    @GetMapping("/operation")
    public List<OperationStock> getAllOperationStock() {
        return operationStockService.getListOfOperationStock();
    }

    @GetMapping("/operation/{id}")
    public OperationStock getOperationStockById(@PathVariable String id) {
        return operationStockService.getOperationStockById(id);
    }

    @PostMapping("/operation")
    public OperationStock createOperationStock(@RequestBody OperationStock operationStock) {
        return operationStockService.createOperationStock(operationStock);
    }

    @PutMapping("/operation")
    public OperationStock updateOperationStock(@RequestBody OperationStock operationStock) {
        return operationStockService.updateOperationStock(operationStock);
    }

    @DeleteMapping("/operation")
    public void deleteOperationStock(@PathVariable String id) {
        operationStockService.deleteOperationStock(id);
    }
}
