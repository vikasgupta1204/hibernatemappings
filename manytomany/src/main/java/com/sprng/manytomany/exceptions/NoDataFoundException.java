package com.sprng.manytomany.exceptions;

import javax.naming.NameNotFoundException;

public class NoDataFoundException extends RuntimeException{
    public NoDataFoundException(String message){
        super(message);
    }
}
