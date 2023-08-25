package com.project.schoolManagementSystem.service;

import com.project.schoolManagementSystem.dto.db.PersonDTO;

import java.time.LocalDate;
import java.util.List;

public interface PersonService {
    PersonDTO getSelf();

    void deletePerson(String username);

    List<PersonDTO> getAll();
    List<PersonDTO> getAll(LocalDate from);
    List<PersonDTO> getAll(LocalDate from, LocalDate to);
}
