package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.StudentDTO;
import com.project.schoolManagementSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{username}")
    public StudentDTO getStudent(@PathVariable String username){
        return studentService.getStudent(username);
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

}
