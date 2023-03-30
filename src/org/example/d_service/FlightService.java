package org.example.d_service;

import org.example.a_dao.FlightDataAccess;
import org.example.c_dto.FlightDataTransfer;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private static final FlightService SERVICE = new FlightService();

    private FlightService() {
    }

    private final FlightDataAccess flightDataAccess = FlightDataAccess.getDataAccess();

    public List<FlightDataTransfer> findAllFlightsDto() {
        return flightDataAccess.findAll()
                .stream()
                .map(flight -> FlightDataTransfer.builder()
                        .id(flight.getId())
                        .description(
                                "Departure airport: %s, Arrival airport: %s, Status: %s"
                                        .formatted(flight.getDepartureAirport(), flight.getArrivalAirport(), flight.getStatus()))
                        .build())
                .collect(Collectors.toList());
    }

    public static FlightService getService() {
        return SERVICE;
    }
}
