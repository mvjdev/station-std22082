package com.example.stationstd22082.repository;

import com.example.stationstd22082.model.ProductTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductTemplateRepository {
    private final Connection connection;

    public List<ProductTemplate> getAll() throws SQLException {
        String sql = "SELECT * FROM product_template";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<ProductTemplate> productTemplatesList = new ArrayList<>();
        while (resultSet.next()) {
            productTemplatesList.add(new ProductTemplate(

                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getDouble("stock_quantity")
                    )
            );
        }
        return productTemplatesList;
    }

    public ProductTemplate getProductTemplateById(String id) throws SQLException {
    String sql = "SELECT * FROM product_template  WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new ProductTemplate(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getBigDecimal("price"),
                    resultSet.getDouble("stock_quantity")
            );
        }
        return null;
    }

    public ProductTemplate createProductTemplate(ProductTemplate productTemplate) throws SQLException {
        String sql = "INSERT INTO product_template(id,name, price,stock_quantity) VALUES( ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productTemplate.getId());
        preparedStatement.setString(2, productTemplate.getName());
        preparedStatement.setBigDecimal(3, productTemplate.getPrice());
        preparedStatement.setDouble(4, productTemplate.getStockQuantity());
        preparedStatement.execute();
        return productTemplate;
    }

    public ProductTemplate updateProductTemplate(ProductTemplate productTemplate) throws SQLException {
        String sql = "UPDATE product_template SET name = ?, price = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productTemplate.getName());
        preparedStatement.setBigDecimal(2, productTemplate.getPrice());
        preparedStatement.setString(3, productTemplate.getId());
        preparedStatement.setDouble(4, productTemplate.getStockQuantity());
        preparedStatement.execute();
        return productTemplate;
    }

    public ProductTemplate deleteProductTemplate(ProductTemplate productTemplate) throws SQLException {
        String sql = "DELETE FROM product_template WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, productTemplate.getId());
        preparedStatement.executeUpdate();
        return productTemplate;
    }
}
