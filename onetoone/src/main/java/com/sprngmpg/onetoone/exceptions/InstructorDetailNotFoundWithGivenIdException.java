package com.sprngmpg.onetoone.exceptions;

public class InstructorDetailNotFoundWithGivenIdException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    String message;

    public InstructorDetailNotFoundWithGivenIdException(String message) {
        this.message = message;
    }

    public InstructorDetailNotFoundWithGivenIdException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public InstructorDetailNotFoundWithGivenIdException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public InstructorDetailNotFoundWithGivenIdException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public InstructorDetailNotFoundWithGivenIdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }

    @Override
    public String toString() {
        return "InstructorDetailNotFoundWithGivenIdException{" +
                "message='" + message + '\'' +
                '}';
    }
}
