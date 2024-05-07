package com.fiap.producao.data.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document(collection = "produto")
public class ProdutoEntity {

    @Id
    private String id;

    private String nome;

    private String descricao;

    private Float preco;

    private String categoriaId;

}

