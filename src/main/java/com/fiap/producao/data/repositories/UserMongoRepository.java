package com.fiap.producao.data.repositories;

import com.fiap.producao.data.entities.UserEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Hidden
public interface UserMongoRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByCpf(String cpf);
    Optional<UserEntity> findById(String id);
}
