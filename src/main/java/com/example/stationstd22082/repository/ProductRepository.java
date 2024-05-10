package com.example.stationstd22082.repository;

import com.example.stationstd22082.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private final Connection connection;

    public List<Product> getAll() throws SQLException {
        String sql = "SELECT * FROM product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Product> productsList = new ArrayList<>();
        while (resultSet.next()) {
            productsList.add(new Product(
                    resultSet.getString("id"),
                    resultSet.getString("id_station"),
                    resultSet.getString("id_product_template")
            )
            );
        }
        return productsList;
    }

    public Product getProductById(String id) throws SQLException {
        String sql = "SELECT * FROM product WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Product(
                    resultSet.getString("id"),
                    resultSet.getString("id_station"),
                    resultSet.getString("id_product_template")
            );
        }
        return null;
    }

    public Product createProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product (id,id_station, id_product_template) VALUES (? ,?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, product.getId());
        preparedStatement.setString(2,product.getIdStation());
        preparedStatement.setString(3,product.getIdProductTemplate());
        preparedStatement.execute();
        return product;
    }

    public Product updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET id_product_template = ?, id_station = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getIdProductTemplate());
        preparedStatement.setString(2,product.getIdStation());
        preparedStatement.setString(3,product.getId());
        preparedStatement.execute();
        return product;
    }

    public Product deleteProduct(Product product) throws SQLException {
        String sql = "DELETE FROM product WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,product.getId());
        preparedStatement.executeUpdate();
        return product;
    }
}





