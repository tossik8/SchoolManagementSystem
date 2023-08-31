package com.project.schoolManagementSystem.exception;

public class MalformedEmailException extends RuntimeException{
    public MalformedEmailException(String message) {
        super(message);
    }
}
