package com.cagri.flightsearchapi.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
public class Flight {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    @Column
    private LocalDateTime returnDate;

    @Column(nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    // Constructors
    public Flight() {
        // Default constructor
    }

    public Flight(Long id, LocalDateTime departureDate, LocalDateTime returnDate, Integer price, Airport departureAirport, Airport arrivalAirport) {
        this.id = id;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }


}
