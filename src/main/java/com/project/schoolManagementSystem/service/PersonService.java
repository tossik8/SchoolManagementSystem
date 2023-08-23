package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    PersonDTO getSelf();

    void deletePerson(String username);

    List<PersonDTO> getAll();
}
