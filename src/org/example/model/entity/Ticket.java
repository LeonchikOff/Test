package org.example.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Ticket {
    private Long id;
    private String passengerNumber;
    private String passengerName;
    private Long flightId;
    private String seatNumber;
    private BigDecimal cost;

    public Ticket(Long id, String passengerNumber, String passengerName, Long flightId, String seatNumber, BigDecimal cost) {
        this.id = id;
        this.passengerNumber = passengerNumber;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(String passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + id +
               ", passengerNumber='" + passengerNumber + '\'' +
               ", passengerName='" + passengerName + '\'' +
               ", flight=" + flightId +
               ", seatNumber='" + seatNumber + '\'' +
               ", cost=" + cost +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(id, ticket.id) &&
               Objects.equals(passengerNumber, ticket.passengerNumber) &&
               Objects.equals(passengerName, ticket.passengerName) &&
               Objects.equals(flightId, ticket.flightId) &&
               Objects.equals(seatNumber, ticket.seatNumber) &&
               Objects.equals(cost, ticket.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passengerNumber, passengerName, flightId, seatNumber, cost);
    }
}
