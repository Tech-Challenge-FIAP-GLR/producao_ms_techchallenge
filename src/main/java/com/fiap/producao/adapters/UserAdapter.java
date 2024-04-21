package com.fiap.producao.adapters;


import com.fiap.producao.entities.UserEntity;
import com.fiap.producao.models.UserModel;
import com.fiap.producao.repositories.UserMongoRepository;
import com.fiap.producao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class UserAdapter implements UserRepository {

    @Autowired
    private final UserMongoRepository userMongoRepository;

    public UserAdapter(UserMongoRepository userJpaRepository) {
        this.userMongoRepository = userJpaRepository;
    }

    @Transactional
    public UserModel salvar(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(userModel.getNome());
        userEntity.setCpf(userModel.getCpf());
        userEntity.setEmail(userModel.getEmail());
        userModel.setId((userMongoRepository.save(userEntity).getId()));
        return userModel;
    }

    public UserModel listaUsuario(String id) throws Exception {
        try {
            Optional<UserEntity> user = userMongoRepository.findById(id);
            return UserModel.fromEntity(user.get());
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }
    }

    @Override

    public UserModel listaUsuariosPorCpf(String cpf) throws Exception {
        try {
            var user = userMongoRepository.findByCpf(cpf);
            return UserModel.fromEntity(user.get());
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }
    }

    public void deletaUser(String id) throws Exception {
        try {
            userMongoRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }
    }

}

