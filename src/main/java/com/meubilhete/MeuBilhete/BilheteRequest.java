package com.meubilhete.MeuBilhete;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BilheteRequest(
    @NotNull(message = "Número do concurso é obrigatório.")
    Integer concurso,
    @NotNull(message = "As dezenas são obrigatórias.")
    @Size(min = 6, max = 15, message = "Escolha entre 6 dezenas e 15 dezenas.")
    List<Integer> dezenas

) {

}
