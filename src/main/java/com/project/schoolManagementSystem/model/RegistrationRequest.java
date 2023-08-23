package com.project.schoolManagementSystem.model;

import com.project.schoolManagementSystem.enumeration.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public abstract class RegistrationRequest {
    private String name;
    private String surname;
    private String username;
    private String password;
    private LocalDate birthDate;
    private Role role;
}
