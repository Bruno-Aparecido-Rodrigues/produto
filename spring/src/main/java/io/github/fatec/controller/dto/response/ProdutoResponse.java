package io.github.fatec.controller.dto.response;

import java.math.BigDecimal;

public record ProdutoResponse(
        String id,
        String nome,
        BigDecimal preco
) {}
