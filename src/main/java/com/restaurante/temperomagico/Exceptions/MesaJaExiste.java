package com.restaurante.temperomagico.Exceptions;

public class MesaJaExiste extends RuntimeException{
    public MesaJaExiste(){
    };

    public MesaJaExiste (String message){
        super(message);
    };
}
