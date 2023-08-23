package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.EmployeeDTO;
import com.project.schoolManagementSystem.entity.Employee;
import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final UserDetailsService userDetailsService;
    private final PersonRepository personRepository;

    @Override
    public EmployeeDTO getEmployee(String username) {
        Employee employee = (Employee) userDetailsService.loadUserByUsername(username);
        return new EmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Person> employees = personRepository.findAllByRole(Role.TEACHER);
        List<EmployeeDTO> employeeDTOS = new ArrayList<>(employees.size());
        employees.forEach(employee -> employeeDTOS.add(new EmployeeDTO((Employee) employee)));
        return employeeDTOS;
    }
}
