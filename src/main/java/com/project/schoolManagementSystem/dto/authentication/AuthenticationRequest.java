package com.project.schoolManagementSystem.dto.authentication;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}
