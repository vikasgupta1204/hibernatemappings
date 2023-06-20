package com.sprngmpg.onetoone.exceptions;

public class InstructorNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    String message;

    @Override
    public String toString() {
        return "InstructorNotFoundException{" +
                "message='" + message + '\'' +
                '}';
    }

    public  InstructorNotFoundException(String message){
    super(message);
}

}
