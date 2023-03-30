package org.example.b_model.entity;

import org.example.b_model.FlightStatus;

import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    private Long id;
    private String flightNumber;
    private Integer aircraftId;
    private String departureAirport;
    private LocalDateTime departureDate;
    private String arrivalAirport;
    private LocalDateTime arrivalDate;
    private FlightStatus status;

    public Flight(Long id, String flightNumber, Integer aircraftId, String departureAirport, LocalDateTime departureDate, String arrivalAirport, LocalDateTime arrivalDate, FlightStatus status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.aircraftId = aircraftId;
        this.departureAirport = departureAirport;
        this.departureDate = departureDate;
        this.arrivalAirport = arrivalAirport;
        this.arrivalDate = arrivalDate;
        this.status = status;
    }

    public Flight() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Integer getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(Integer aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) &&
               Objects.equals(flightNumber, flight.flightNumber) &&
               Objects.equals(aircraftId, flight.aircraftId) &&
               Objects.equals(departureAirport, flight.departureAirport) &&
               Objects.equals(departureDate, flight.departureDate) &&
               Objects.equals(arrivalAirport, flight.arrivalAirport) &&
               Objects.equals(arrivalDate, flight.arrivalDate) &&
               status == flight.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNumber, aircraftId, departureAirport, departureDate, arrivalAirport, arrivalDate, status);
    }

    @Override
    public String toString() {
        return "Flight{" +
               "id=" + id +
               ", flightNumber='" + flightNumber + '\'' +
               ", aircraftId=" + aircraftId +
               ", departureAirport='" + departureAirport + '\'' +
               ", departureDate=" + departureDate +
               ", arrivalAirport='" + arrivalAirport + '\'' +
               ", arrivalDate=" + arrivalDate +
               ", status=" + status +
               '}';
    }
}
