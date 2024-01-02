package com.cagri.flightsearchapi.service.serviceImpl;

import com.cagri.flightsearchapi.dto.FlightDTO;
import com.cagri.flightsearchapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;


@Component
public class FlightDataUpdateJob {
    private final FlightService flightService;
    private final WebClient webClient;

    @Autowired
    public FlightDataUpdateJob(FlightService flightService, WebClient webClient) {
        this.flightService = flightService;
        this.webClient = webClient;
    }

    @Scheduled(cron = "0 0 0 * * ?") // It will run every day at 00:00:00
    //@Scheduled(cron = "0/10 * * * * *") // It will run every 10 seconds
    public void updateFlightData() {
        try {

            //Get data from third-party API
            String apiUrl = "https://mpef9fc547ddfa4cfe0f.free.beeceptor.com/mockflight";
            FlightDTO[] flights = webClient.get()
                    .uri(apiUrl)
                    .retrieve()
                    .bodyToMono(FlightDTO[].class)
                    .block();

            //Save to Database
            if (flights != null) {
                for (FlightDTO flightDTO : flights) {
                    flightService.createFlight(flightDTO);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
