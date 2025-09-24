package com.example.animais.dtos;

public record AnimalResponseDTO(
        Long id,
        String nome,
        String especie,
        int idade
) {
}
