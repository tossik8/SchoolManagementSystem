package com.project.schoolManagementSystem.dto.update;

import com.project.schoolManagementSystem.enumeration.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(callSuper = true)
public class UpdateEmployeeRequest extends UpdatePersonRequest{
    private Role role;
    private int salary;
    private LocalDate hireDate;
    private LocalDate fireDate;
}
