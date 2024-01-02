package com.cagri.flightsearchapi.service;

import com.cagri.flightsearchapi.dto.AirportDTO;

import java.util.List;

public interface AirportService {
    List<AirportDTO> getAllAirports();

    AirportDTO getAirportById(Long id);

    AirportDTO createAirport(AirportDTO airportDTO);

    AirportDTO updateAirport(Long id, AirportDTO airportDTO);

    void deleteAirport(Long id);
}
