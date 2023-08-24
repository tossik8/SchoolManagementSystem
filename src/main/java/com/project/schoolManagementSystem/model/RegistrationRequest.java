package com.project.schoolManagementSystem.model;

import com.project.schoolManagementSystem.enumeration.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class RegistrationRequest {
    private String name;
    private String surname;
    private String username;
    private String password;
    private LocalDate birthDate;
    private Role role;
}
