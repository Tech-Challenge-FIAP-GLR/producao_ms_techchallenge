package com.fiap.producao.domain.ports;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.domain.models.ProdutoModel;

import java.util.List;

public interface ProdutoUseCasePort {

    ProdutoModel executeListar(String id) throws Exception;
    List<ProdutoEntity> executeListarCategoria(String descricaoCategoria) throws Exception;
    ProdutoModel executeSalvar(ProdutoModel produtoModel);
    ProdutoModel executeAtualizar(ProdutoModel produtoModel);
    void executeDeletar(String id);
}
