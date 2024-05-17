package com.fiap.producao.data.response;

import com.fiap.producao.domain.models.ProdutoModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoResponse {
    private String id;
    private String nome;
    private String descricao;
    private Float preco;
    private CategoriaResponse categoria;

    public ProdutoResponse(String id, String nome, String descricao, Float preco, CategoriaResponse categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(ProdutoModel produtoModel){
        return new ProdutoResponse(produtoModel.getId(), produtoModel.getNome(), produtoModel.getDescricao(), produtoModel.getPreco(), CategoriaResponse.fromDomain(produtoModel.getCategoriaModel()));
    }

}
