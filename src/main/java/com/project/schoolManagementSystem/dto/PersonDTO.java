package com.project.schoolManagementSystem.dto;

import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.enumeration.Role;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
@Getter
@Setter
public abstract class PersonDTO {
    private String name;
    private String surname;
    private String username;
    private LocalDate birthDate;
    private Role role;
    protected PersonDTO(Person person){
        name = person.getName();
        surname = person.getSurname();
        username = person.getUsername();
        birthDate = person.getBirthDate();
        role = person.getRole();
    }
}
