package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO getEmployee(String username);

    List<EmployeeDTO> getAllEmployees();
}
