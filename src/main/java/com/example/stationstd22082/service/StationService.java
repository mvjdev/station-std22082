package com.example.stationstd22082.service;

import com.example.stationstd22082.model.Station;
import com.example.stationstd22082.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class StationService {
    private final StationRepository stationRepository;

    public List<Station> getListOfStations() {
        try {
            return stationRepository.getAll();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Station getStationById(String id) {
        try {
            return stationRepository.getStationById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Station createStation(Station station) {
        try {
            return stationRepository.createStation(station);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Station updateStation(Station station) {
    try {
        return stationRepository.updateStation(station);
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    }

    public void deleteStation(Station station) {
        try {
            stationRepository.deleteStation(station);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
