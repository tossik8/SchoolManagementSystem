package com.project.schoolManagementSystem.dto.registration;

import com.project.schoolManagementSystem.dto.registration.RegistrationRequest;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class StudentRegistrationRequest extends RegistrationRequest {
    private boolean enrolled;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
