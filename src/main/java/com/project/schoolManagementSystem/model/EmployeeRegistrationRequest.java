package com.project.schoolManagementSystem.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString(callSuper = true)
@Getter
@Setter
public class EmployeeRegistrationRequest extends RegistrationRequest {
    private int salary;
    private LocalDate hireDate;
    private LocalDate fireDate;
}
