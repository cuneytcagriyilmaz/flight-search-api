package com.cagri.flightsearchapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FlightDTO {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime departureDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime returnDate;
    private Integer price;
    private AirportDTO departureAirport;
    private AirportDTO arrivalAirport;

    public FlightDTO() {
        // Default constructor
    }

    public FlightDTO(Long id, LocalDateTime departureDate, LocalDateTime returnDate, Integer price, AirportDTO departureAirport, AirportDTO arrivalAirport) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }


}
