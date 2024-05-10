package com.example.stationstd22082.service;

import com.example.stationstd22082.model.OperationStock;
import com.example.stationstd22082.repository.OperationStockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class OperationStockService {
    private final OperationStockRepository operationStockRepository;

    public List<OperationStock> getListOfOperationStock() {
        try {
            return operationStockRepository.getAll();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public OperationStock getOperationStockById(String id) {
        try {
            return operationStockRepository.getOperationStockById(id);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public OperationStock createOperationStock(OperationStock operationStock) {
        try {
            return operationStockRepository.createOperationStock(operationStock);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public OperationStock updateOperationStock(OperationStock operationStock) {
        try {
            return operationStockRepository.updateOperationStock(operationStock);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public OperationStock deleteOperationStock(String id) {
        try {
            operationStockRepository.deleteOperationStock(operationStockRepository.getOperationStockById(id));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
