package com.fiap.producao.domain.models;

import com.fiap.producao.data.entities.CategoriaEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaModel {

    private String id;
    private String descricao;

    public CategoriaModel(String id) {
        this.id = id;
        this.descricao = "";
    }

    public CategoriaModel(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

//    public CategoriaModel(String descricao) {
//        this.descricao = descricao;
//    }

    public static CategoriaModel fromEntity(CategoriaEntity categoriaEntity) {
        return new CategoriaModel(categoriaEntity.getId(), categoriaEntity.getDescricao());
    }

    public CategoriaModel() {
    }
}

