package io.github.fatec.repository.mongo;

import io.github.fatec.repository.orm.ProdutoOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryWithMongoDB extends MongoRepository<ProdutoOrmMongo, String> {}
