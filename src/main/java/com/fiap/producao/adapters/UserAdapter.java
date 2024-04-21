package com.fiap.producao.adapters;


import com.fiap.producao.entities.UserEntity;
import com.fiap.producao.models.UserModel;
import com.fiap.producao.repositories.UserMongoRepository;
import com.fiap.producao.repositories.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class UserAdapter implements UserRepository {

    private final UserMongoRepository userJpaRepository;

    public UserAdapter(UserMongoRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Transactional
    public UserModel salvar(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setNome(userModel.getNome());
        userEntity.setCpf(userModel.getCpf());
        userEntity.setEmail(userModel.getEmail());
        userModel.setId((userJpaRepository.save(userEntity).getId()));
        return userModel;
    }

    public UserModel listaUsuario(Long id) throws Exception {
        try {
            var user = userJpaRepository.findById(id);
            return UserModel.fromEntity(user.get());
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }
    }

    @Override
    public UserModel listaUsuariosPorCpf(String id) {
        return null;
    }

//    public UserModel listaUsuariosPorCpf(String cpf) {
//        try {
//            var user = userJpaRepository.findByCpf(cpf);
//            return UserModel.fromEntity(user.get());
//        } catch (Exception e) {
//            throw new EntityNotFoundException();
//        }
//    }

    public void deletaUser(Long id) throws Exception {
        try {
            userJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }
    }

}

