package com.fiap.producao.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collection = "user")
public class UserEntity {
    @Id
    private String id;

    private String nome;

    private String cpf;

    private String email;

    public UserEntity() {
    }
    public UserEntity(String id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
