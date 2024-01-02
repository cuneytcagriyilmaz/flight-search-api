package com.cagri.flightsearchapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AirportDTO {
    private Long id;
    private String city;

    // Constructors
    public AirportDTO() {
        // Default constructor
    }

    public AirportDTO(Long id, String city) {
        this.id = id;
        this.city = city;
    }

}
