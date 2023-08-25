package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.PersonDTO;
import com.project.schoolManagementSystem.dto.StudentDTO;
import com.project.schoolManagementSystem.dto.EmployeeDTO;
import com.project.schoolManagementSystem.entity.Employee;
import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.entity.Student;
import com.project.schoolManagementSystem.enumeration.Role;
import com.project.schoolManagementSystem.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;
    private final UserDetailsService userDetailsService;

    @Override
    public PersonDTO getSelf() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getAuthorities().contains(new SimpleGrantedAuthority(Role.STUDENT.name()))){
            return new StudentDTO((Student) authentication.getPrincipal());
        }
        return new EmployeeDTO((Employee) authentication.getPrincipal());
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> people = personRepository.findAll();
        return makePersonDTOList(people);
    }

    @Override
    public List<PersonDTO> getAll(LocalDate from) {
        List<Person> people = personRepository.findAllByBirthdateAfter(from);
        return makePersonDTOList(people);
    }

    @Override
    public List<PersonDTO> getAll(LocalDate from, LocalDate to) {
        List<Person> people = personRepository.findAllByBirthdateBetween(from, to);
        return makePersonDTOList(people);
    }

    private List<PersonDTO> makePersonDTOList(List<Person> people){
        List<PersonDTO> peopleDTO = new LinkedList<>();
        for (Person person : people){
            if(person.getRole() == Role.STUDENT){
                peopleDTO.add(new StudentDTO((Student) person));
            }
            else{
                peopleDTO.add(new EmployeeDTO((Employee) person));
            }
        }
        return peopleDTO;
    }

    @Override
    public void deletePerson(String username) {
        Person person = (Person) userDetailsService.loadUserByUsername(username);
        personRepository.delete(person);
    }
}
