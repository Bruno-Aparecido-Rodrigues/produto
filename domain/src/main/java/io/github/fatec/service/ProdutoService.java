package io.github.fatec.service;

import io.github.fatec.entity.Produto;

import java.util.List;

public interface ProdutoService {

    Produto criar(Produto produto);

    Produto atualizar(Produto produto);

    void deletar(String id);

    List<Produto> listar();

    Produto buscarPorId(String id);
}
