package org.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.model.Gender;
import org.example.model.Role;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String avatar;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private Role role;
    private Gender gender;
}
