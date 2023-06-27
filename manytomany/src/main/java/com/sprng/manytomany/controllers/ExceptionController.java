package com.sprng.manytomany.controllers;

import com.sprng.manytomany.exceptions.CourseNotFoundException;
import com.sprng.manytomany.exceptions.ErrorResponse;
import com.sprng.manytomany.exceptions.NoDataFoundException;
import com.sprng.manytomany.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionController{

    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> noStudentFoundWithId(StudentNotFoundException studentNotFoundException)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setData("STUDENT_NOT_FOUND");
        errorResponse.setCode(404);
        errorResponse.setMessage(studentNotFoundException.getMessage());
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus("Student is not found with the provided Id. Please provide valid Id");
       return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> noStudentFoundWithId(NoDataFoundException noDataFoundException)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setData("NO_DATA_FOUND");
        errorResponse.setCode(404);
        errorResponse.setMessage(noDataFoundException.getMessage());
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus("No student found");
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> noStudentFoundWithId(CourseNotFoundException courseNotFoundException)
    {
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setData("NO_COURSE_FOUND");
        errorResponse.setCode(404);
        errorResponse.setMessage(courseNotFoundException.getMessage());
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus("Course not found");
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
