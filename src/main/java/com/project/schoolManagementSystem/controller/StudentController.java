package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.db.StudentDTO;
import com.project.schoolManagementSystem.dto.update.UpdateStudentRequest;
import com.project.schoolManagementSystem.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/{username}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateStudent(@PathVariable String username, @Valid @RequestBody UpdateStudentRequest request){
        studentService.updateStudent(username, request);
    }

    @GetMapping("/all")
    public List<StudentDTO> getAllStudents(){
        return studentService.getAllStudents();
    }

}
