package org.example.c_dto;

public class FlightDataTransfer implements DataTransferableObject {
    private final Long id;
    private final String description;

    public FlightDataTransfer(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "FlightDataTransfer{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }
}
