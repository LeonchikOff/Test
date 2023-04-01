package org.example.dto;

import lombok.Builder;
import lombok.Value;
import org.example.model.Gender;
import org.example.model.Role;

import java.time.LocalDate;

@Value
@Builder
public class ReadUserTransfer  implements DataTransferableObject{
    Integer id;
    String avatar;
    String name;
    LocalDate dateOfBirth;
    String email;
    Role role;
    Gender gender;
}
