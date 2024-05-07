package com.fiap.producao.domain.usecases;


import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.models.ProdutoModel;
import com.fiap.producao.domain.ports.ProdutoUseCasePort;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import com.fiap.producao.domain.repositories.ProdutoRepository;

import java.util.List;

public class ProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoUseCase(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public ProdutoModel executeSalvar(ProdutoModel produtoModel) {
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoRepository.salvar(produtoModel);
    }

    @Override
    public ProdutoModel executeListar(String id) throws Exception {
        ProdutoModel produtoModel = produtoRepository.listaProduto(id);
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoModel;
    }

    @Override
    public List<ProdutoEntity> executeListarCategoria(String descricaoCategoria) throws Exception {
        CategoriaModel categoriaModel = categoriaRepository.listarCategoriaByDescricao(descricaoCategoria);
        return produtoRepository.listaProdutoCategoria(categoriaModel.getId());
    }

    @Override
    public ProdutoModel executeAtualizar(ProdutoModel produtoModel) {
        produtoModel.setCategoriaModel(categoriaRepository.listarCategoriaById(produtoModel.getCategoriaModel().getId()));
        return produtoRepository.atualizaProduto(produtoModel);
    }

    @Override
    public void executeDeletar(String id) {
        produtoRepository.deletaProduto(id);
    }
}
