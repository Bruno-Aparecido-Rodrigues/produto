package io.github.fatec.controller.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record VendaResponse(
        String id,
        Integer numero,
        String clienteId,
        String nomeCliente,
        List<ItemVendaResponse> itens,
        BigDecimal total,
        LocalDateTime dataVenda
) {}
