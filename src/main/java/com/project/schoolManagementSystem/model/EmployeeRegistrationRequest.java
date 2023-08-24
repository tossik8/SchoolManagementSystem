package com.project.schoolManagementSystem.model;


import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class EmployeeRegistrationRequest extends RegistrationRequest {
    private int salary;
    private LocalDate hireDate;
    private LocalDate fireDate;
}
