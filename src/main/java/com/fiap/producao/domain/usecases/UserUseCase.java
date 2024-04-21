package com.fiap.producao.domain.usecases;


import com.fiap.producao.domain.models.UserModel;
import com.fiap.producao.domain.ports.UserUseCasePort;
import com.fiap.producao.data.repositories.UserMongoRepository;
import com.fiap.producao.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUseCase implements UserUseCasePort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMongoRepository userMongoRepository;


    @Override
    public UserModel salvar(UserModel userModel) {

        return userRepository.salvar(userModel);
    }

    @Override
    public UserModel listaUsuarios(String id) throws Exception {
        UserModel userModel = userRepository.listaUsuario(id);
        return userModel;
    }

    @Override
    public UserModel listaUsuariosPorCpf(String cpf) throws Exception {
        UserModel userModel = userRepository.listaUsuariosPorCpf(cpf);
        return userModel;
    }

    @Override
    public void deletaUser(String id) throws Exception {
        userRepository.deletaUser(id);
    }


    }
