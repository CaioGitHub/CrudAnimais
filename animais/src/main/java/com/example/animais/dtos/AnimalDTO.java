package com.example.animais.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AnimalDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotBlank(message = "A espécie é obrigatória")
        String especie,

        @NotNull(message = "A idade é obrigatória")
        @Positive(message = "A idade deve ser um número positivo")
        int idade
) {
}
