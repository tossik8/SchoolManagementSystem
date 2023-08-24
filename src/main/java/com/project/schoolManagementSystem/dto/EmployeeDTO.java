package com.project.schoolManagementSystem.dto;

import com.project.schoolManagementSystem.entity.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
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
