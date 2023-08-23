package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.StudentDTO;
import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.entity.Student;
import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final UserDetailsService userDetailsService;
    private final PersonRepository personRepository;
    @Override
    public StudentDTO getStudent(String username) {
        Student student = (Student) userDetailsService.loadUserByUsername(username);
        return new StudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Person> students = personRepository.findAllByRole(Role.STUDENT);
        List<StudentDTO> studentDTOS = new ArrayList<>(students.size());
        students.forEach(student -> studentDTOS.add(new StudentDTO((Student) student)));
        return studentDTOS;
    }
}
