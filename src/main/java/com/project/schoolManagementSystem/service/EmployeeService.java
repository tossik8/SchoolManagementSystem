package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.db.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployee(String username);

    List<EmployeeDTO> getAllEmployees();
}
