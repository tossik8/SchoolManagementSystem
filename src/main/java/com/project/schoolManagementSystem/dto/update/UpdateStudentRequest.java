package com.project.schoolManagementSystem.dto.update;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString(callSuper = true)
public class UpdateStudentRequest extends UpdatePersonRequest{
    private boolean enrolled;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
}
