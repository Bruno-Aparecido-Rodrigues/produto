package io.github.fatec.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Venda(
        String id,
        Integer numero,
        String clienteId,
        String nomeCliente,
        List<ItemVenda> itens,
        BigDecimal total,
        LocalDateTime dataVenda
) {}
