package com.sai.web.exceptions;

public class InvalidPropertyFileException extends FrameworkException{

    public InvalidPropertyFileException(String message){
        super(message);
    }

    public InvalidPropertyFileException(String message, Throwable cause){
        super(message, cause);
    }
}
