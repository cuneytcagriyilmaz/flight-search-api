package com.cagri.flightsearchapi.repository;

import com.cagri.flightsearchapi.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;



@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    List<Flight>findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateBetween(
            String departureAirport_city, String arrivalAirport_city, LocalDateTime startDate, LocalDateTime endDate);

    List<Flight>findByDepartureAirportCityAndArrivalAirportCityAndDepartureDateBetweenAndReturnDateBetween(

            String departureAirport_city, String arrivalAirport_city, LocalDateTime departureDateStart,
            LocalDateTime departureDateEnd, LocalDateTime returnDateStart, LocalDateTime returnDateEnd);


}

