package com.example.stationstd22082.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@ConfigurationProperties("station")

public class ConnectionProperties {
    private String url;
    private String username;
    private String password;
}
