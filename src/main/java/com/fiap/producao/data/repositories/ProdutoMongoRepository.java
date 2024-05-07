package com.fiap.producao.data.repositories;

import com.fiap.producao.data.entities.ProdutoEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Hidden
public interface ProdutoMongoRepository extends MongoRepository<ProdutoEntity, String> {

    List<ProdutoEntity> findAllByCategoriaId(String id);
}
