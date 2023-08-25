package com.project.schoolManagementSystem.repository;

import com.project.schoolManagementSystem.entity.Person;
import com.project.schoolManagementSystem.enumeration.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByUsername(String username);
    List<Person> findAllByRole(Role role);
    List<Person> findAllByBirthDateAfter(LocalDate from);
    List<Person> findAllByBirthDateBetween(LocalDate from, LocalDate to);
}
