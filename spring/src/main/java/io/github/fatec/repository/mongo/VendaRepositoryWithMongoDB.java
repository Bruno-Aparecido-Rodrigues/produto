package io.github.fatec.repository.mongo;

import io.github.fatec.repository.orm.VendaOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendaRepositoryWithMongoDB extends MongoRepository<VendaOrmMongo, String> {

    Optional<VendaOrmMongo> findByNumero(Integer numero);

    List<VendaOrmMongo> findByClienteId(String clienteId);
}
