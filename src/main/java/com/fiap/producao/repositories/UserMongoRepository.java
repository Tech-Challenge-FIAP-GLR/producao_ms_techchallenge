package com.fiap.producao.repositories;

import com.fiap.producao.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<UserEntity, Long> {
}
