package com.fiap.producao.repositories;


import com.fiap.producao.models.UserModel;

public interface UserRepository {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuario(String id) throws Exception;
    UserModel listaUsuariosPorCpf(String id) throws Exception;
    void deletaUser(String id) throws Exception;
}
