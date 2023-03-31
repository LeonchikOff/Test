package org.example.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserForCreateDataTransfer implements DataTransferableObject {
    String name;
    String dateOfBirth;
    String email;
    String password;
    String role;
    String gender;
}
