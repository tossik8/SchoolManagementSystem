package com.project.schoolManagementSystem.dto.registration;

import com.project.schoolManagementSystem.enumeration.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class RegistrationRequest {
    private String name;
    private String surname;
    private String email;
    private LocalDate birthdate;
    private Role role;
}
