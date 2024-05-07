package com.fiap.producao.domain.repositories;

import com.fiap.producao.domain.models.CategoriaModel;

public interface CategoriaRepository {

    CategoriaModel listarCategoriaById(String id);

    CategoriaModel listarCategoriaByDescricao(String descricao);
}
