package com.example.stationstd22082.repository;

import com.example.stationstd22082.model.Station;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class StationRepository {
    private final Connection connection;

    public List<Station> getAll() throws SQLException {
        String sql = "SELECT * FROM station";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Station> stationsList = new ArrayList<>();

        while (resultSet.next()) {
            stationsList.add(new Station(
                    resultSet.getString("id"),
                    resultSet.getString("location"),
                    resultSet.getTimestamp("create_at").toInstant(),
                    resultSet.getTimestamp("update_at").toInstant()
            )
            );
        }
        return stationsList;
    }

    public Station createStation(Station station) throws SQLException {
        String query = "INSERT INTO station (id, location, create_at, update_at) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, station.getId());
        preparedStatement.setString(2, station.getLocation());
        preparedStatement.setTimestamp(3,Timestamp.from(station.getCreateAt()));
        preparedStatement.setTimestamp(4,Timestamp.from(station.getUpdateAt()));
        preparedStatement.executeUpdate();
        return station;
    }

    public Station updateStation(Station station) throws SQLException {
        String query = "UPDATE station SET location = ?, update_at = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, station.getLocation());
        preparedStatement.setTimestamp(2, Timestamp.from(station.getUpdateAt()));
        preparedStatement.setString(3, station.getId());
        preparedStatement.executeUpdate();
        return station;
    }

    public Station deleteStation(Station station) throws SQLException {
        String query = "DELETE FROM station WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, station.getId());
        preparedStatement.executeUpdate();
        return station;
    }

    public Station getStationById(String id) throws SQLException {
        String query = "SELECT * FROM station WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Station();
        }
        return null;
    }
}
