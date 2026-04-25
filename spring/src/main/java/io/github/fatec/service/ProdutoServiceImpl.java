package io.github.fatec.service;

import io.github.fatec.entity.Produto;
import io.github.fatec.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Produto criar(Produto produto) {
        return repository.salvar(produto);
    }

    @Override
    public Produto atualizar(Produto produto) {
        return repository.atualizar(produto);
    }

    @Override
    public void deletar(String id) {
        repository.deletar(id);
    }

    @Override
    public List<Produto> listar() {
        return repository.listar();
    }

    @Override
    public Produto buscarPorId(String id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + id));
    }
}
