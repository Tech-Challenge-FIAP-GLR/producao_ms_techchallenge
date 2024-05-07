package com.fiap.producao.domain.repositories;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.domain.models.ProdutoModel;

import java.util.List;

public interface ProdutoRepository {

    ProdutoModel salvar(ProdutoModel produtoModel);
    ProdutoModel listaProduto(String id) throws Exception;
    List<ProdutoEntity> listaProdutoCategoria(String id) throws Exception;
    ProdutoModel atualizaProduto(ProdutoModel produtoModel);
    void deletaProduto(String id);
}
