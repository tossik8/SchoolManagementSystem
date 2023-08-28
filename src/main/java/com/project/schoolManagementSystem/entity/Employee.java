package com.project.schoolManagementSystem.entity;


import com.project.schoolManagementSystem.dto.registration.EmployeeRegistrationRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table
public class Employee extends Person {

    @Column(nullable = false)
    private LocalDate hireDate;
    private LocalDate fireDate;
    @Column(nullable = false)
    private int salary;

    public Employee(EmployeeRegistrationRequest request, String password) {
        super(request, password);
        this.hireDate = request.getHireDate();
        this.fireDate = request.getFireDate();
        this.salary = request.getSalary();
    }

    @Override
    public boolean isEnabled() {
        return this.fireDate == null;
    }
}
