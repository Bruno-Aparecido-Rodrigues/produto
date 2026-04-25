package io.github.fatec.entity;

import java.math.BigDecimal;

public record ItemVenda(
        String produtoId,
        String nomeProduto,
        Integer quantidade,
        BigDecimal precoUnitario
) {}
