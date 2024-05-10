package com.example.stationstd22082.repository;

import com.example.stationstd22082.model.OperationStock;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class OperationStockRepository {
    private final Connection connection;

    public List<OperationStock> getAll() throws SQLException {
        String sql = "SELECT * FROM operation_stock";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<OperationStock> operationStocksList = new ArrayList<>();

        while (resultSet.next()) {
            operationStocksList.add(new OperationStock(
                    resultSet.getString("id"),
                    resultSet.getString("id_product"),
                    resultSet.getBigDecimal("quantity"),
                    resultSet.getTimestamp("date_time").toInstant(),
                    resultSet.getString("type")
            )
            );
        }
        return operationStocksList;
    }

    public OperationStock getOperationStockById(String id) throws SQLException {
        String sql = "SELECT * FROM operation_stock WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new OperationStock(
                    resultSet.getString("id"),
                    resultSet.getString("id_product"),
                    resultSet.getBigDecimal("quantity"),
                    resultSet.getTimestamp("date_time").toInstant(),
                    resultSet.getString("type")
            );
        }
        return null;
    }

    public OperationStock createOperationStock(OperationStock operationStock) throws SQLException {
        String sql = "INSERT INTO operation_stock (id, id_product, quantity, date_time, type) VALUES (? ,?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, operationStock.getId());
        preparedStatement.setString(2, operationStock.getIdProduct());
        preparedStatement.setBigDecimal(3, operationStock.getQuantity());
        preparedStatement.setTimestamp(4,Timestamp.from(operationStock.getDateTime()));
        preparedStatement.setString(5, operationStock.getType());
        preparedStatement.executeUpdate();
        return operationStock;
    }

    public OperationStock updateOperationStock(OperationStock operationStock) throws SQLException {
        String query = "UPDATE operation_stock SET id_product = ?, quantity = ?, date_time = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, operationStock.getIdProduct());
        preparedStatement.setBigDecimal(2, operationStock.getQuantity());
        preparedStatement.setTimestamp(3, Timestamp.from(operationStock.getDateTime()));
        preparedStatement.setString(4, operationStock.getId());
        preparedStatement.executeUpdate();
        return operationStock;
    }

    public OperationStock deleteOperationStock(OperationStock operationStock) throws SQLException {
        String query = "DELETE FROM operation_stock WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, operationStock.getId());
        preparedStatement.executeUpdate();
        return operationStock;
    }
}
