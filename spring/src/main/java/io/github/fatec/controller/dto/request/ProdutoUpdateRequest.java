package io.github.fatec.controller.dto.request;

import java.math.BigDecimal;

public record ProdutoUpdateRequest(
        String id,
        String nome,
        BigDecimal preco
) {}
