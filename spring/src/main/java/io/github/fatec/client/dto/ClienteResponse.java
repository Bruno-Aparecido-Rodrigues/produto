package io.github.fatec.client.dto;

import java.time.LocalDate;

public record ClienteResponse(
        String id,
        String nome,
        LocalDate dataNascimento,
        EnderecoClienteResponse endereco
) {}
