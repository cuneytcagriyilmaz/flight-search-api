package com.cagri.flightsearchapi.service.serviceImpl;

import com.cagri.flightsearchapi.dto.FlightDTO;
import com.cagri.flightsearchapi.entity.Airport;
import com.cagri.flightsearchapi.entity.Flight;
import com.cagri.flightsearchapi.mapper.FlightMapper;
import com.cagri.flightsearchapi.repository.AirportRepository;
import com.cagri.flightsearchapi.repository.FlightRepository;
import com.cagri.flightsearchapi.service.FlightService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    private final AirportRepository airportRepository;

    private final FlightMapper flightMapper;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, AirportRepository airportRepository, FlightMapper flightMapper) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;

        this.flightMapper = flightMapper;
    }

    @Override
    public List<FlightDTO> getAllFlights() {
        return flightRepository.findAll().stream()
                .map(flightMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with id: " + id));
        return flightMapper.convertToDto(flight);
    }

    @Override
    public FlightDTO createFlight(FlightDTO flightDTO) {
        Flight flight = flightMapper.convertToEntity(flightDTO);
        Flight savedFlight = flightRepository.save(flight);
        return flightMapper.convertToDto(savedFlight);
    }


    @Override
    public FlightDTO updateFlight(Long id, FlightDTO flightDTO) {
        Flight existingFlight = flightRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Flight not found with id: " + id));

        Airport departureAirport = airportRepository.findById(flightDTO.getDepartureAirport().getId())
                .orElseThrow(() -> new EntityNotFoundException("Departure Airport not found with id: " + flightDTO.getDepartureAirport().getId()));

        Airport arrivalAirport = airportRepository.findById(flightDTO.getArrivalAirport().getId())
                .orElseThrow(() -> new EntityNotFoundException("Arrival Airport not found with id: " + flightDTO.getArrivalAirport().getId()));

        existingFlight.setDepartureDate(flightDTO.getDepartureDate());
        existingFlight.setReturnDate(flightDTO.getReturnDate());
        existingFlight.setPrice(flightDTO.getPrice());
        existingFlight.setDepartureAirport(departureAirport);
        existingFlight.setArrivalAirport(arrivalAirport);

        Flight updatedFlight = flightRepository.save(existingFlight);
        return flightMapper.convertToDto(updatedFlight);
    }


    @Override
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


    @Override
    public List<FlightDTO> getFlightsByCityAndDate(String departureCity, String arrivalCity, LocalDate departureDate, LocalDate returnDate) {
        LocalDateTime departureStartDateTime = departureDate.atStartOfDay();
        LocalDateTime departureEndDateTime = departureDate.atTime(LocalTime.MAX);

        List<Flight> flights;

        if (returnDate == null) {
            flights = flightRepository.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateBetween(
                    departureCity, arrivalCity, departureStartDateTime, departureEndDateTime);
        } else {
            LocalDateTime returnStartDateTime = returnDate.atStartOfDay();
            LocalDateTime returnEndDateTime = returnDate.atTime(LocalTime.MAX);

            flights = flightRepository.findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateBetweenAndReturnDateBetween(
                    departureCity, arrivalCity, departureStartDateTime, departureEndDateTime, returnStartDateTime, returnEndDateTime
            );
        }

        return flights.stream()
                .map(flightMapper::convertToDto)
                .collect(Collectors.toList());
    }

}
