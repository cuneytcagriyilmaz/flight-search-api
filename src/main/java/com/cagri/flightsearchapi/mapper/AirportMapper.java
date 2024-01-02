package com.cagri.flightsearchapi.mapper;

import com.cagri.flightsearchapi.dto.AirportDTO;
import com.cagri.flightsearchapi.entity.Airport;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {
    private final ModelMapper modelMapper;


    public AirportMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public AirportDTO convertToDto(Airport airport) {
        return modelMapper.map(airport, AirportDTO.class);
    }

    public Airport convertToEntity(AirportDTO airportDTO) {
        return modelMapper.map(airportDTO, Airport.class);
    }
}
