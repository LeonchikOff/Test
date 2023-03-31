package org.example.dto;

import lombok.*;

@Value
@Builder
public class FlightDataTransfer implements DataTransferableObject {
    Long id;
    String description;
}
