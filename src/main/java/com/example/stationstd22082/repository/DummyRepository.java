package com.example.stationstd22082.repository;

import com.example.stationstd22082.model.Dummy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class DummyRepository {
    private final Connection connection;

    public List<Dummy> getAll() throws SQLException {
        String query = "SELECT * FROM dummy";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<Dummy> dummyList = new ArrayList<>();

        while (resultSet.next()) {
            dummyList.add(
                    new Dummy(
                         resultSet.getString("id"),
                         resultSet.getString("name")
                    )
            );
        }
        return dummyList;
    }
}
