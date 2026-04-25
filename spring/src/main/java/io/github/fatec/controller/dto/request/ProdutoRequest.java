package io.github.fatec.controller.dto.request;

import java.math.BigDecimal;

public record ProdutoRequest(
        String nome,
        BigDecimal preco
) {}
