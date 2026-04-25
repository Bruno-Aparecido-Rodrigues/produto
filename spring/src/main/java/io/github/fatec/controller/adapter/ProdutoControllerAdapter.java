package io.github.fatec.controller.adapter;

import io.github.fatec.controller.dto.request.ItemVendaRequest;
import io.github.fatec.controller.dto.request.ProdutoRequest;
import io.github.fatec.controller.dto.request.ProdutoUpdateRequest;
import io.github.fatec.controller.dto.request.VendaRequest;
import io.github.fatec.controller.dto.response.ItemVendaResponse;
import io.github.fatec.controller.dto.response.ProdutoResponse;
import io.github.fatec.controller.dto.response.VendaResponse;
import io.github.fatec.entity.ItemVenda;
import io.github.fatec.entity.Produto;
import io.github.fatec.entity.Venda;

import java.util.List;

public class ProdutoControllerAdapter {

    private ProdutoControllerAdapter() {}

    public static Produto cast(ProdutoRequest request) {
        return new Produto(null, request.nome(), request.preco());
    }

    public static Produto cast(ProdutoUpdateRequest request) {
        return new Produto(request.id(), request.nome(), request.preco());
    }

    public static ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.id(), produto.nome(), produto.preco());
    }

    public static Venda castVenda(VendaRequest request) {
        List<ItemVenda> itens = request.itens().stream()
                .map(i -> new ItemVenda(i.produtoId(), null, i.quantidade(), null))
                .toList();
        return new Venda(null, null, request.clienteId(), null, itens, null, null);
    }

    public static VendaResponse toVendaResponse(Venda venda) {
        List<ItemVendaResponse> itens = venda.itens().stream()
                .map(i -> new ItemVendaResponse(
                        i.produtoId(),
                        i.nomeProduto(),
                        i.quantidade(),
                        i.precoUnitario()))
                .toList();
        return new VendaResponse(
                venda.id(),
                venda.numero(),
                venda.clienteId(),
                venda.nomeCliente(),
                itens,
                venda.total(),
                venda.dataVenda()
        );
    }
}
