package io.github.fatec.client.dto;

public record EnderecoClienteResponse(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
