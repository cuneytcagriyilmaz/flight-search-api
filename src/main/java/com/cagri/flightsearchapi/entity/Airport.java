package com.cagri.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Airport {


    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String city;

    public Airport() {

    }

    public Airport(Long id, String city) {
        this.id = id;
        this.city = city;
    }

}
