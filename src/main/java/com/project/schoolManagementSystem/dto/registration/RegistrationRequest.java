package com.project.schoolManagementSystem.dto.registration;

import com.project.schoolManagementSystem.enumeration.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class RegistrationRequest {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Surname is mandatory")
    private String surname;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotNull(message = "Birthdate is mandatory")
    private LocalDate birthdate;
    @NotNull(message = "Role is mandatory")
    private Role role;
}
