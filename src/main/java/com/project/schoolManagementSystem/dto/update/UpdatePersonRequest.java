package com.project.schoolManagementSystem.dto.update;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@ToString
@Getter
@Setter
public abstract class UpdatePersonRequest {
    private String name;
    private String surname;
    private LocalDate birthdate;
}
