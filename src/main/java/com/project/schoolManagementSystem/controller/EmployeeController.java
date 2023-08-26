package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.db.EmployeeDTO;
import com.project.schoolManagementSystem.dto.update.UpdateEmployeeRequest;
import com.project.schoolManagementSystem.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    @PutMapping("/{username}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable String username, @RequestBody UpdateEmployeeRequest request){
        employeeService.updateEmployee(username, request);
    }

    @GetMapping("/all")
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
