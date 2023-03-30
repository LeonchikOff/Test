package org.example.c_dto;

public class TicketDataTransfer implements DataTransferableObject {
    private final Long id;
    private final Long flightId;
    private final String seatNumber;

    public TicketDataTransfer(Long id, Long flightId, String seatNumber) {
        this.id = id;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public Long getFlightId() {
        return flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    @Override
    public String toString() {
        return "TicketDataTransfer{" +
               "id=" + id +
               ", flightId=" + flightId +
               ", seatNumber='" + seatNumber + '\'' +
               '}';
    }
}


