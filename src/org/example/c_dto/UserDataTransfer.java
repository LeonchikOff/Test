package org.example.c_dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDataTransfer implements DataTransferableObject {
    Long id;
    String email;
}
