package com.sprng.manytomany.exceptions;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message) {
    super(message);
    }
}
