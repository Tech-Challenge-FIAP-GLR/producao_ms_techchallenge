package com.fiap.producao.domain.ports;

import com.fiap.producao.domain.models.UserModel;

public interface UserUseCasePort {

    UserModel salvar(UserModel userModel);
    UserModel listaUsuarios(String id) throws Exception;
    UserModel listaUsuariosPorCpf(String id) throws Exception;
    void deletaUser(String id) throws Exception;
}
