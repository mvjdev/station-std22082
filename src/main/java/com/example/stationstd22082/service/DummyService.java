package com.example.stationstd22082.service;

import com.example.stationstd22082.model.Dummy;
import com.example.stationstd22082.repository.DummyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class DummyService {
    private final DummyRepository dummyRepository;

    public List<Dummy> getListOfDummy() {
        try{
            return dummyRepository.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}