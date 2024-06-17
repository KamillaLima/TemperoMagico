package com.restaurante.temperomagico.exception;

public class PasswordInvalidException extends RuntimeException{

    public PasswordInvalidException (String message){
        super(message);
    }

}
