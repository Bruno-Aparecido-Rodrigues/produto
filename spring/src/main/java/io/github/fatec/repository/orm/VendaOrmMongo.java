package io.github.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "vendas")
public record VendaOrmMongo(
        @Id
        String id,
        Integer numero,
        String clienteId,
        String nomeCliente,
        List<ItemVendaOrm> itens,
        BigDecimal total,
        LocalDateTime dataVenda
) {}
