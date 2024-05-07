package com.fiap.producao.domain.usecases;

import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.ports.CategoriaUseCasePort;
import com.fiap.producao.domain.repositories.CategoriaRepository;

public class CategoriaUseCase implements CategoriaUseCasePort {

    private CategoriaRepository categoriaRepository;
    @Override
    public CategoriaModel executeId(String id) {
        return categoriaRepository.listarCategoriaById(id);
    }

    @Override
    public CategoriaModel execute(String descricao) {
        return categoriaRepository.listarCategoriaByDescricao(descricao);
    }
}
