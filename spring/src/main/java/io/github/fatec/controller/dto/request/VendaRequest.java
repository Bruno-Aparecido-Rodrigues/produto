package io.github.fatec.controller.dto.request;

import java.util.List;

public record VendaRequest(
        String clienteId,
        List<ItemVendaRequest> itens
) {}
