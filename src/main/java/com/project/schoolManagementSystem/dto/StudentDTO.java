package com.project.schoolManagementSystem.dto;

import com.project.schoolManagementSystem.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO extends PersonDTO {
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private boolean isEnrolled;

    public StudentDTO(Student student) {
        super(student);
        enrollmentDate = student.getEnrollmentDate();
        graduationDate = student.getGraduationDate();
        isEnrolled = student.isEnrolled();
    }
}
