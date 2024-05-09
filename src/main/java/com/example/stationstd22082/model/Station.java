package com.example.stationstd22082.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station implements Serializable {
    private String id;
    private String location;
    private Instant createAt;
    private Instant updateAt;
}
