package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.db.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO getStudent(String username);

    List<StudentDTO> getAllStudents();
}
