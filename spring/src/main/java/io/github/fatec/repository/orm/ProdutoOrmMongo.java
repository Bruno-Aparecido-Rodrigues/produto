package io.github.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "produtos")
public record ProdutoOrmMongo(
        @Id
        String id,
        String nome,
        BigDecimal preco
) {}
