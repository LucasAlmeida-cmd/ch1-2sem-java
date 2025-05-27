package com.example.GS1.exceptions;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException(String texto) {
        super(texto);
    }
}
