package io.github.fatec.controller.dto.response;

import java.math.BigDecimal;

public record ItemVendaResponse(
        String produtoId,
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario
) {}
