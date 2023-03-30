package org.example.d_service;

import org.example.a_dao.TicketDataAccess;
import org.example.c_dto.TicketDataTransfer;

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
                .map(ticket -> new TicketDataTransfer(ticket.getId(), ticket.getFlightId(), ticket.getSeatNumber()))
                .collect(Collectors.toList());
    }


    public static TicketService getService() {
        return SERVICE;
    }
}
