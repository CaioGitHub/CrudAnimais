package com.example.animais.exceptions;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(Long id) {
        super("Animal com ID " + id + " não encontrado.");
    }
}
