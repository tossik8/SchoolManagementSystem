package com.project.schoolManagementSystem.dto.update;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(callSuper = true)
public class UpdateStudentRequest extends UpdatePersonRequest{
    @NotNull(message = "Enrolled is mandatory")
    private boolean enrolled;
    @NotNull(message = "Enrollment date is mandatory")
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
