package io.github.fatec.repository;

import io.github.fatec.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    Produto salvar(Produto produto);

    Produto atualizar(Produto produto);

    void deletar(String id);

    List<Produto> listar();

    Optional<Produto> buscarPorId(String id);
}
