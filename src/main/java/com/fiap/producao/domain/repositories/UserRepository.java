package com.fiap.producao.domain.repositories;


import com.fiap.producao.domain.models.UserModel;

public interface UserRepository {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuario(String id) throws Exception;
    UserModel listaUsuariosPorCpf(String id) throws Exception;
    void deletaUser(String id) throws Exception;
}
