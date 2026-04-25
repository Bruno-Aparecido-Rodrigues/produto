package io.github.fatec.repository;

import io.github.fatec.entity.Venda;
import io.github.fatec.repository.adapter.VendaRepositoryAdapter;
import io.github.fatec.repository.mongo.VendaRepositoryWithMongoDB;
import io.github.fatec.repository.orm.VendaOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VendaRepositoryImpl implements VendaRepository {

    private final VendaRepositoryWithMongoDB repository;

    public VendaRepositoryImpl(VendaRepositoryWithMongoDB repository) {
        this.repository = repository;
    }

    @Override
    public Venda salvar(Venda venda) {
        VendaOrmMongo orm = VendaRepositoryAdapter.castEntity(venda);
        VendaOrmMongo ormSaved = repository.save(orm);
        return VendaRepositoryAdapter.castOrm(ormSaved);
    }

    @Override
    public List<Venda> listar() {
        return repository.findAll()
                .stream()
                .map(VendaRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Venda> buscarPorNumero(Integer numero) {
        return repository.findByNumero(numero)
                .map(VendaRepositoryAdapter::castOrm);
    }

    @Override
    public List<Venda> buscarPorClienteId(String clienteId) {
        return repository.findByClienteId(clienteId)
                .stream()
                .map(VendaRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }
}
