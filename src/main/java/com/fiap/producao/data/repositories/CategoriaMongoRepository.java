package com.fiap.producao.data.repositories;

import com.fiap.producao.data.entities.CategoriaEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;

@Hidden
public interface CategoriaMongoRepository extends MongoRepository<CategoriaEntity, String> {
    Object findByDescricao(String descricao);
}
