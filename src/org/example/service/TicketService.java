package org.example.service;

import org.example.dao.TicketDataAccess;
import org.example.dto.TicketDataTransfer;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private static final TicketService SERVICE = new TicketService();

    private TicketService() {
    }

    private final TicketDataAccess ticketDataAccess = TicketDataAccess.getDataAccess();

    public List<TicketDataTransfer> findAllTicketsDtoByFlightId(Long flightId) {
        return ticketDataAccess.findAllTicketsByFlightId(flightId)
                .stream()
                .map(ticket -> TicketDataTransfer.builder()
                        .id(ticket.getId())
                        .flightId(ticket.getFlightId())
                        .seatNumber(ticket.getSeatNumber())
                        .build())
                .collect(Collectors.toList());
    }


    public static TicketService getService() {
        return SERVICE;
    }
}
