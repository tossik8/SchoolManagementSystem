package com.project.schoolManagementSystem.dto.registration;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RegistrationResponse {
    private String token;
    private String password;
}
