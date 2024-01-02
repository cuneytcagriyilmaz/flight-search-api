package com.cagri.flightsearchapi.service;

import com.cagri.flightsearchapi.dto.FlightDTO;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {
    List<FlightDTO> getAllFlights();

    FlightDTO getFlightById(Long id);

    FlightDTO createFlight(FlightDTO flightDTO);

    FlightDTO updateFlight(Long id, FlightDTO flightDTO);

    void deleteFlight(Long id);


    List<FlightDTO> getFlightsByCityAndDate(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate returnDate);



}
