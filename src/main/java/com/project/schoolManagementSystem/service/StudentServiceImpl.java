package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.db.StudentDTO;
import com.project.schoolManagementSystem.dto.update.UpdateStudentRequest;
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

    @Override
    public void updateStudent(String username, UpdateStudentRequest request) {
        Student student = (Student) userDetailsService.loadUserByUsername(username);
        student.setName(request.getName());
        student.setSurname(request.getSurname());
        student.setBirthdate(request.getBirthdate());
        student.setEnrolled(request.isEnrolled());
        student.setEnrollmentDate(request.getEnrollmentDate());
        student.setGraduationDate(request.getGraduationDate());
        personRepository.save(student);
    }
}
