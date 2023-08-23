package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.model.AuthenticationRequest;
import com.project.schoolManagementSystem.model.AuthenticationResponse;
import com.project.schoolManagementSystem.model.RegistrationRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
