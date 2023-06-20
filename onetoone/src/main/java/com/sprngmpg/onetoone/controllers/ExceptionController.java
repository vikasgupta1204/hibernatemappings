package com.sprngmpg.onetoone.controllers;


import com.sprngmpg.onetoone.exceptions.ErrorResponse;
import com.sprngmpg.onetoone.exceptions.InstructorDetailNotFoundWithGivenIdException;
import com.sprngmpg.onetoone.exceptions.InstructorNotFoundException;
import jdk.jfr.Timestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value=InstructorNotFoundException.class)
    public ResponseEntity<ErrorResponse> instructorNotFound(InstructorNotFoundException instructorNotFoundException){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(401);
        errorResponse.setData("NOT_FOUND");
        errorResponse.setMessage("No instructor found with given id");
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus("Instructor not found");
        return new ResponseEntity<>(errorResponse
               , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= InstructorDetailNotFoundWithGivenIdException.class)
    public ResponseEntity<ErrorResponse> instructorDetailNotFound(InstructorDetailNotFoundWithGivenIdException instructorDetailNotFoundWithGivenIdException){
        ErrorResponse errorResponse=new ErrorResponse();
        errorResponse.setCode(402);
        errorResponse.setData("NOT_FOUND");
        errorResponse.setMessage(instructorDetailNotFoundWithGivenIdException.getMessage());
        errorResponse.setTimestamp(new Date());
        errorResponse.setStatus("Instructor detail not found");
        return new ResponseEntity<>(errorResponse
                , HttpStatus.NOT_FOUND);
    }


}
