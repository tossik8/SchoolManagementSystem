package com.project.schoolManagementSystem.dto;

import com.project.schoolManagementSystem.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO extends PersonDTO {
    private LocalDate hireDate;
    private LocalDate fireDate;
    private int salary;

    public EmployeeDTO(Employee employee) {
        super(employee);
        hireDate = employee.getHireDate();
        fireDate = employee.getFireDate();
        salary = employee.getSalary();
    }
}
