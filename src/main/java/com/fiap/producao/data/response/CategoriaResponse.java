package com.fiap.producao.data.response;

import com.fiap.producao.domain.models.CategoriaModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaResponse {

    private String id;

    private String descricao;

    public CategoriaResponse(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static CategoriaResponse fromDomain(CategoriaModel categoriaModel){
        return new CategoriaResponse(categoriaModel.getId(), categoriaModel.getDescricao());
    }
}
