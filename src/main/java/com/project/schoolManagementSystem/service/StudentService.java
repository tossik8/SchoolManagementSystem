package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.db.StudentDTO;
import com.project.schoolManagementSystem.dto.update.UpdateStudentRequest;

import java.util.List;

public interface StudentService {
    StudentDTO getStudent(String username);

    List<StudentDTO> getAllStudents();

    void updateStudent(String username, UpdateStudentRequest request);
}
