package com.project.schoolManagementSystem.dto.registration;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class EmployeeRegistrationRequest extends RegistrationRequest {
    @NotBlank(message = "Salary is mandatory")
    private int salary;
    @NotBlank(message = "Hire date is mandatory")
    private LocalDate hireDate;
    private LocalDate fireDate;
}
