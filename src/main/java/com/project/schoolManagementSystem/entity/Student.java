package com.project.schoolManagementSystem.entity;

import com.project.schoolManagementSystem.dto.registration.StudentRegistrationRequest;
import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    @Column(nullable = false)
    private boolean enrolled;

    public Student(StudentRegistrationRequest request,String username, String password) {
        super(request, username, password);
        enrollmentDate = request.getEnrollmentDate();
        graduationDate = request.getGraduationDate();
        enrolled = request.isEnrolled();
    }

    @Override
    public boolean isEnabled() {
        return this.enrolled;
    }
}
