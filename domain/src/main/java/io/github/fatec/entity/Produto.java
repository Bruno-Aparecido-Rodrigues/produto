package io.github.fatec.entity;

import java.math.BigDecimal;

public record Produto(
        String id,
        String nome,
        BigDecimal preco
) {}
