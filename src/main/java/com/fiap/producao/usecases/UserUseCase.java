package com.fiap.producao.usecases;


import com.fiap.producao.models.UserModel;
import com.fiap.producao.ports.UserUseCasePort;
import com.fiap.producao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUseCase implements UserUseCasePort {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserModel salvar(UserModel userModel) {

        return userRepository.salvar(userModel);
    }

    @Override
    public UserModel listaUsuarios(Long id) throws Exception {
        UserModel userModel = userRepository.listaUsuario(id);
        return userModel;
    }

    @Override
    public UserModel listaUsuariosPorCpf(String cpf) {
        UserModel userModel = userRepository.listaUsuariosPorCpf(cpf);
        return userModel;
    }

    @Override
    public void deletaUser(Long id) throws Exception {
        userRepository.deletaUser(id);
    }


    }
