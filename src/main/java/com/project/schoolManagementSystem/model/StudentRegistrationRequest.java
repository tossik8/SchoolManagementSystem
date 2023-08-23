package com.project.schoolManagementSystem.model;

import lombok.*;

import java.time.LocalDate;

@ToString(callSuper = true)
@Getter
@Setter
public class StudentRegistrationRequest extends RegistrationRequest{
    private boolean enrolled;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
