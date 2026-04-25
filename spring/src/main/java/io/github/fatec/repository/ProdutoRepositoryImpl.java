package io.github.fatec.repository;

import io.github.fatec.entity.Produto;
import io.github.fatec.repository.adapter.ProdutoRepositoryAdapter;
import io.github.fatec.repository.mongo.ProdutoRepositoryWithMongoDB;
import io.github.fatec.repository.orm.ProdutoOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoRepositoryWithMongoDB repository;

    public ProdutoRepositoryImpl(ProdutoRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Produto salvar(Produto produto) {
        ProdutoOrmMongo orm = ProdutoRepositoryAdapter.castEntity(produto);
        ProdutoOrmMongo ormSaved = repository.save(orm);
        return ProdutoRepositoryAdapter.castOrm(ormSaved);
    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoOrmMongo orm = ProdutoRepositoryAdapter.castEntity(produto);
        ProdutoOrmMongo ormUpdated = repository.save(orm);
        return ProdutoRepositoryAdapter.castOrm(ormUpdated);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<Produto> listar() {
        return repository.findAll()
                .stream()
                .map(ProdutoRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> buscarPorId(String id) {
        return repository.findById(id)
                .map(ProdutoRepositoryAdapter::castOrm);
    }
}
