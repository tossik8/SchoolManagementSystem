package com.project.schoolManagementSystem.model;


import lombok.Getter;

import java.time.LocalDate;

@Getter
public class EmployeeRegistrationRequest extends RegistrationRequest {
    private int salary;
    private LocalDate hireDate;
    private LocalDate fireDate;
}
