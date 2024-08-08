package com.fiap.producao.data.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String nome;
    private String cpf;
    private String email;
}
