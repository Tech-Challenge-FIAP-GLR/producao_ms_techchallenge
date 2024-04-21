package com.fiap.producao.ports;

import com.fiap.producao.models.UserModel;

public interface UserUseCasePort {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuarios(Long id) throws Exception;
    UserModel listaUsuariosPorCpf(String id);
    void deletaUser(Long id) throws Exception;
}
