package com.fiap.producao.data.adapters;


import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.data.repositories.ProdutoMongoRepository;
import com.fiap.producao.domain.models.ProdutoModel;
import com.fiap.producao.domain.repositories.ProdutoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProdutoAdapter implements ProdutoRepository {

    private final ProdutoMongoRepository produtoMongoRepository;

    public ProdutoAdapter(ProdutoMongoRepository produtoJpaRepository) {
        this.produtoMongoRepository = produtoJpaRepository;
    }

    @Override
    @Transactional
    public ProdutoModel salvar(ProdutoModel produtoModel) {
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(produtoModel.getNome());
        produtoEntity.setDescricao(produtoModel.getDescricao());
        produtoEntity.setPreco(produtoModel.getPreco());
        produtoEntity.setCategoriaId(produtoModel.getCategoriaModel().getId());
        produtoModel.setId(produtoMongoRepository.save(produtoEntity).getId());
        return produtoModel;
    }

    @Override
    public ProdutoModel listaProduto(String id) throws Exception {
        try{
            var produto = produtoMongoRepository.findById(id);
            return ProdutoModel.fromEntity(produto.get());
        } catch (Exception e) {
            throw new Exception("Entity not found");
        }

    }

    @Override
    public List<ProdutoEntity> listaProdutoCategoria(String id) throws Exception {
        try{
            return produtoMongoRepository.findAllByCategoriaId(id);
        } catch (Exception e) {
            throw new Exception("Entity not found");

        }
    }

    @Override
    @Transactional
    public ProdutoModel atualizaProduto(ProdutoModel produtoModel) {
        ProdutoEntity produtoEntity = produtoMongoRepository.findById(produtoModel.getId()).get();
        produtoEntity.setNome(produtoModel.getNome());
        produtoEntity.setDescricao(produtoModel.getDescricao());
        produtoEntity.setPreco(produtoModel.getPreco());
        produtoEntity.setCategoriaId(produtoModel.getCategoriaModel().getId());
        produtoMongoRepository.save(produtoEntity);
        return produtoModel;
    }

    @Override
    @Transactional
    public void deletaProduto(String id) {
        produtoMongoRepository.deleteById(id);
    }
}
