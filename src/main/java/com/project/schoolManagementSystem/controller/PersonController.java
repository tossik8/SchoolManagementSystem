package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.dto.db.PersonDTO;
import com.project.schoolManagementSystem.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping
    public PersonDTO getSelf(){
        return personService.getSelf();
    }

    @GetMapping("/all")
    public List<PersonDTO> getAll(@RequestParam(required = false) LocalDate birthdateFrom,
                                  @RequestParam(required = false) LocalDate birthdateTo){
        if(birthdateFrom != null && birthdateTo != null){
            return personService.getAll(birthdateFrom, birthdateTo);
        }
        else if (birthdateFrom != null){
            return personService.getAll(birthdateFrom);
        }
        return personService.getAll();
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable String username){
        personService.deletePerson(username);
    }
}
