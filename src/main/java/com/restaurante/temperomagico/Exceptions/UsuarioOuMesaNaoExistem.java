package com.restaurante.temperomagico.Exceptions;

public class UsuarioOuMesaNaoExistem extends RuntimeException{
    public UsuarioOuMesaNaoExistem(String message){
        super(message);
    }    
}
