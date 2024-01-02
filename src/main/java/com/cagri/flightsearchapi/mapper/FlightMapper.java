package com.cagri.flightsearchapi.mapper;

import com.cagri.flightsearchapi.dto.FlightDTO;
import com.cagri.flightsearchapi.entity.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {
    private final ModelMapper modelMapper;

    public FlightMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public FlightDTO convertToDto(Flight flight) {
        return modelMapper.map(flight, FlightDTO.class);
    }

    public Flight convertToEntity(FlightDTO flightDTO) {
        return modelMapper.map(flightDTO, Flight.class);
    }
}
