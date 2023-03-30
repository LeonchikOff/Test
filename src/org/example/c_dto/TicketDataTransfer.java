package org.example.c_dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketDataTransfer implements DataTransferableObject {
    Long id;
    Long flightId;
    String seatNumber;

}


