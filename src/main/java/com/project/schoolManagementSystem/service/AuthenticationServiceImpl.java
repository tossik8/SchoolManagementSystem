package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.entity.Employee;
import com.project.schoolManagementSystem.entity.Student;
import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.model.*;
import com.project.schoolManagementSystem.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepository;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegistrationRequest request) {
        AuthenticationResponse response;
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        if (request.getRole() == Role.STUDENT){
            Student student = new Student((StudentRegistrationRequest) request);
            personRepository.save(student);
            response = new AuthenticationResponse(jwtService.generateToken(student));
        }
        else{
            Employee employee = new Employee((EmployeeRegistrationRequest) request);
            personRepository.save(employee);
            response = new AuthenticationResponse(jwtService.generateToken(employee));
        }
        return response;
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        return new AuthenticationResponse(jwtService.generateToken(userDetails));
    }
}
