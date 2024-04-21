package com.fiap.producao.repositories;


import com.fiap.producao.models.UserModel;

public interface UserRepository {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuario(Long id) throws Exception;
    UserModel listaUsuariosPorCpf(String id);
    void deletaUser(Long id) throws Exception;
}
