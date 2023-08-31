package com.project.schoolManagementSystem.controller;

import com.project.schoolManagementSystem.exception.InvalidRoleAssignmentException;
import com.project.schoolManagementSystem.exception.MalformedEmailException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<String> handleEntityExistsException(EntityExistsException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
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
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getBody().getDetail());
    }
    @ExceptionHandler(MalformedEmailException.class)
    public ResponseEntity<String> handleMalformedEmailException(MalformedEmailException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
}
