package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.EmployeeDTO;
import com.project.schoolManagementSystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/{username}")
    public EmployeeDTO getEmployee(@PathVariable String username){
        return employeeService.getEmployee(username);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
