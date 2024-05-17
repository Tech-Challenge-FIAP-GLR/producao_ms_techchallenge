package com.fiap.producao.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "categoria")
public class CategoriaEntity {

    @Id
    private String id;

    private String descricao;

    public CategoriaEntity() {
    }

    public CategoriaEntity(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

}

