package com.example.stationstd22082.controller;

import com.example.stationstd22082.model.Dummy;
import com.example.stationstd22082.service.DummyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class DummyController {
    private final DummyService  dummyService;

    @GetMapping("/dummies")
    public List<Dummy> getAll() {
        return dummyService.getListOfDummy();
    }
}
