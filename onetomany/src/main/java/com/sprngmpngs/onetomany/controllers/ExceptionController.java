package com.sprngmpngs.onetomany.controllers;

import com.sprngmpngs.onetomany.exceptions.CourseNotFoundWithGivenId;
import com.sprngmpngs.onetomany.exceptions.ErrorResponse;
import com.sprngmpngs.onetomany.exceptions.InstructorNotFoundWithGivenId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = InstructorNotFoundWithGivenId.class)
    public ResponseEntity<ErrorResponse> instructorNotFound(InstructorNotFoundWithGivenId instructorNotFoundWithGivenId){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(403);
        errorResponse.setData("NOT_FOUND");
        errorResponse.setMessage(instructorNotFoundWithGivenId.getMessage());
        errorResponse.setTimestamp(new Date());
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = CourseNotFoundWithGivenId.class)
    public ResponseEntity<ErrorResponse> courseNotFound(CourseNotFoundWithGivenId courseNotFoundWithGivenId){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(403);
        errorResponse.setData("NOT_FOUND");
        errorResponse.setMessage(courseNotFoundWithGivenId.getMessage());
        errorResponse.setTimestamp(new Date());
        return  new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
