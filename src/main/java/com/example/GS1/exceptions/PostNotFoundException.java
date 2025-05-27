package com.example.GS1.exceptions;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String texto) {
        super(texto);
    }
}
