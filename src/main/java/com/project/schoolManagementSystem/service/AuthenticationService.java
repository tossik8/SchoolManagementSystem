package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.authentication.AuthenticationRequest;
import com.project.schoolManagementSystem.dto.authentication.AuthenticationResponse;
import com.project.schoolManagementSystem.dto.registration.RegistrationRequest;

public interface AuthenticationService {
    String register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
