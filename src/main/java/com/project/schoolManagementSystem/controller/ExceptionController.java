package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.exception.InvalidRoleAssignmentException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(InvalidRoleAssignmentException.class)
    public ResponseEntity<String> handleUnauthorizedRoleException(InvalidRoleAssignmentException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<String> handleClassCastException(ClassCastException exception){
        Pattern pattern = Pattern.compile("entity\\.\\w+");
        Matcher matcher = pattern.matcher(exception.getMessage());
        if(matcher.find()){
            String type = matcher.group().toLowerCase().replaceAll("entity.", "");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The provided username corresponds to" +
                    " a(n) " + type +  " and this endpoint does not access " + type + " data");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @ExceptionHandler(PropertyValueException.class)
    public ResponseEntity<String> handlePropertyValueException(PropertyValueException exception){
        Pattern pattern = Pattern.compile("\\w+$");
        Matcher matcher = pattern.matcher(exception.getMessage());
        if(matcher.find()){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(matcher.group() + " cannot be null");
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
}
