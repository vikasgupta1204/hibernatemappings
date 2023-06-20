package com.sprngmpngs.onetomany.exceptions;

public class InstructorNotFoundWithGivenId extends RuntimeException{
    String message;
    public InstructorNotFoundWithGivenId(String message){
        super(message);
    }

}
