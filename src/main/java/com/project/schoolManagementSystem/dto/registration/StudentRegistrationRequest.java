package com.project.schoolManagementSystem.dto.registration;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class StudentRegistrationRequest extends RegistrationRequest {
    @NotNull(message = "Enrolled is mandatory")
    private boolean enrolled;
    @NotNull(message = "Enrollment date is mandatory")
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
