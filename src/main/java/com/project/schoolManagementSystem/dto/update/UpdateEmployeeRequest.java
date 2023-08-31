package com.project.schoolManagementSystem.dto.update;

import com.project.schoolManagementSystem.enumeration.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(callSuper = true)
public class UpdateEmployeeRequest extends UpdatePersonRequest{
    @NotNull(message = "Role is mandatory")
    private Role role;
    @NotNull(message = "Salary is mandatory")
    private int salary;
    @NotNull(message = "Hire date is mandatory")
    private LocalDate hireDate;
    private LocalDate fireDate;
}
