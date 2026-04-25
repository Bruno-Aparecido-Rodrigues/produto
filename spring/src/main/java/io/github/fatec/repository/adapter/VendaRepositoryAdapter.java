package io.github.fatec.repository.adapter;

import io.github.fatec.entity.ItemVenda;
import io.github.fatec.entity.Venda;
import io.github.fatec.repository.orm.ItemVendaOrm;
import io.github.fatec.repository.orm.VendaOrmMongo;

import java.util.List;
import java.util.stream.Collectors;

public class VendaRepositoryAdapter {

    private VendaRepositoryAdapter() {}

    public static Venda castOrm(VendaOrmMongo orm) {
        List<ItemVenda> itens = orm.itens().stream()
                .map(i -> new ItemVenda(
                        i.produtoId(),
                        i.nomeProduto(),
                        i.quantidade(),
                        i.precoUnitario()
                ))
                .collect(Collectors.toList());

        return new Venda(
                orm.id(),
                orm.numero(),
                orm.clienteId(),
                orm.nomeCliente(),
                itens,
                orm.total(),
                orm.dataVenda()
        );
    }

    public static VendaOrmMongo castEntity(Venda entity) {
        List<ItemVendaOrm> itens = entity.itens().stream()
                .map(i -> new ItemVendaOrm(
                        i.produtoId(),
                        i.nomeProduto(),
                        i.quantidade(),
                        i.precoUnitario()
                ))
                .collect(Collectors.toList());

        return new VendaOrmMongo(
                entity.id(),
                entity.numero(),
                entity.clienteId(),
                entity.nomeCliente(),
                itens,
                entity.total(),
                entity.dataVenda()
        );
    }
}
