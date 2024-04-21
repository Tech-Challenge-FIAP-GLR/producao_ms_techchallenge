package com.fiap.producao.repositories;

import com.fiap.producao.entities.UserEntity;
import com.fiap.producao.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMongoRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByCpf(String cpf);
    Optional<UserEntity> findById(String id);
}
