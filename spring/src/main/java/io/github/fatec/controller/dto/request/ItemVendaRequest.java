package io.github.fatec.controller.dto.request;

public record ItemVendaRequest(
        String produtoId,
        Integer quantidade
) {}
