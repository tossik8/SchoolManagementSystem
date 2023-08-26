package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.authentication.AuthenticationRequest;
import com.project.schoolManagementSystem.dto.authentication.AuthenticationResponse;
import com.project.schoolManagementSystem.dto.registration.RegistrationRequest;
import com.project.schoolManagementSystem.dto.registration.RegistrationResponse;

public interface AuthenticationService {
    RegistrationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
