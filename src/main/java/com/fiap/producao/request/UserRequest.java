package com.fiap.producao.request;

import com.fiap.producao.models.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String nome;

    private String cpf;

    private String email;

    public UserModel toUserDomain(){
        UserModel userModel = new UserModel();
        userModel.setNome(this.nome);
        userModel.setCpf(this.cpf);
        userModel.setEmail(this.email);

        return userModel;
    }

}
