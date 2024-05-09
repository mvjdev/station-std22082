package com.example.stationstd22082.repository.configurations;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@RequiredArgsConstructor
public class ConnectionConf {
    private final ConnectionProperties connectionProperties;
    @Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                connectionProperties.getUrl(),
                connectionProperties.getUsername(),
                connectionProperties.getPassword()
        );
    }
}
