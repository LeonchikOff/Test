package org.example.dto;

import lombok.Builder;
import lombok.Value;

import javax.servlet.http.Part;

@Value
@Builder
public class CreateUserTransfer implements DataTransferableObject {
    Part avatar;
    String name;
    String dateOfBirth;
    String email;
    String password;
    String role;
    String gender;
}
