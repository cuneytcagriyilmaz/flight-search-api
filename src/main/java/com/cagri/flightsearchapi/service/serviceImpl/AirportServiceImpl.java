package com.cagri.flightsearchapi.service.serviceImpl;

import com.cagri.flightsearchapi.dto.AirportDTO;
import com.cagri.flightsearchapi.entity.Airport;
import com.cagri.flightsearchapi.mapper.AirportMapper;
import com.cagri.flightsearchapi.repository.AirportRepository;
import com.cagri.flightsearchapi.service.AirportService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final AirportMapper airportMapper;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    @Override
    public List<AirportDTO> getAllAirports() {

        return airportRepository.findAll().stream()
                .map(airportMapper::convertToDto)
                .collect(Collectors.toList());
    }


    @Override
    public AirportDTO getAirportById(Long id) {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
        return airportMapper.convertToDto(airport);
    }

    @Override
    public AirportDTO createAirport(AirportDTO airportDTO) {
        Airport airport = airportMapper.convertToEntity(airportDTO);
        Airport savedAirport = airportRepository.save(airport);
        return airportMapper.convertToDto(savedAirport);
    }

    @Override
    public AirportDTO updateAirport(Long id, AirportDTO airportDTO) {
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Airport not found with id: " + id));
        Airport updatedAirport = airportRepository.save(existingAirport);
        return airportMapper.convertToDto(updatedAirport);
    }

    @Override
    public void deleteAirport(Long id) {
        airportRepository.deleteById(id);
    }

}

