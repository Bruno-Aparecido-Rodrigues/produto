package io.github.fatec.repository.adapter;

import io.github.fatec.entity.Produto;
import io.github.fatec.repository.orm.ProdutoOrmMongo;

public class ProdutoRepositoryAdapter {

    private ProdutoRepositoryAdapter() {}

    public static Produto castOrm(ProdutoOrmMongo orm) {
        return new Produto(
                orm.id(),
                orm.nome(),
                orm.preco()
        );
    }

    public static ProdutoOrmMongo castEntity(Produto entity) {
        return new ProdutoOrmMongo(
                entity.id(),
                entity.nome(),
                entity.preco()
        );
    }
}
