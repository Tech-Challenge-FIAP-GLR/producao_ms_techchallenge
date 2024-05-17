package com.fiap.producao.domain.ports;

import com.fiap.producao.domain.models.CategoriaModel;

public interface CategoriaUseCasePort {
    CategoriaModel executeId(String id);

    CategoriaModel execute(String descricao);
}


