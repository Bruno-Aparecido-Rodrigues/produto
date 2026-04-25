package io.github.fatec.repository.orm;

import java.math.BigDecimal;

public record ItemVendaOrm(
        String produtoId,
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario
) {}
