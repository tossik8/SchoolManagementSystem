package com.project.schoolManagementSystem.entity;

import com.project.schoolManagementSystem.model.StudentRegistrationRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Student extends Person{

    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    private boolean enrolled;

    public Student(StudentRegistrationRequest request) {
        super(request);
        enrollmentDate = request.getEnrollmentDate();
        graduationDate = request.getGraduationDate();
        enrolled = request.isEnrolled();
    }

    @Override
    public boolean isEnabled() {
        return this.enrolled;
    }
}