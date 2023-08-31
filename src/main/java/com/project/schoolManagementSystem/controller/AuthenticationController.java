package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.authentication.AuthenticationRequest;
import com.project.schoolManagementSystem.dto.authentication.AuthenticationResponse;
import com.project.schoolManagementSystem.dto.registration.EmployeeRegistrationRequest;
import com.project.schoolManagementSystem.dto.registration.StudentRegistrationRequest;
import com.project.schoolManagementSystem.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/student/registration")
    public String register(@RequestBody StudentRegistrationRequest request){
        return authenticationService.register(request);
    }

    @PostMapping("/employee/registration")
    public String register(@RequestBody EmployeeRegistrationRequest request){
        return authenticationService.register(request);
    }

    @PostMapping("/login")
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request){
        return authenticationService.authenticate(request);
    }
}

