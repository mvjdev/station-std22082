package com.example.stationstd22082.controller;

import com.example.stationstd22082.model.Station;
import com.example.stationstd22082.service.StationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StationController {
    private final StationService stationService;

    @GetMapping("/station")
    public List<Station> getAllStations() {
        return stationService.getListOfStations();
    }

    @GetMapping("/station/{id}")
    public Station getStationById(@PathVariable String id) {
        return stationService.getStationById(id);
    }

    @PutMapping("/station")
    public Station updateStation(@RequestBody Station station) {
        return stationService.updateStation(station);
    }

    @DeleteMapping("/station/{id}")
    public void deleteStation(@PathVariable String id) {
        stationService.deleteStation(id);
    }

    @PostMapping("/station")
    public void createStation(@RequestBody Station station) {
        stationService.createStation(station);
    }
}
