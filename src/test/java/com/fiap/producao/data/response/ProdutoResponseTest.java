package com.fiap.producao.data.response;

import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.models.ProdutoModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProdutoResponseTest {

    @Test
    void testFromDomain() {
        // Arrange
        String id = "1";
        String nome = "Produto Teste";
        String descricao = "Descrição do Produto";
        Float preco = 50.0f;
        CategoriaModel categoriaModel = new CategoriaModel("1", "Categoria Teste");
        ProdutoModel produtoModel = new ProdutoModel(id, nome, descricao, preco, categoriaModel);

        // Act
        ProdutoResponse produtoResponse = ProdutoResponse.fromDomain(produtoModel);

        // Assert
        assertEquals(id, produtoResponse.getId());
        assertEquals(nome, produtoResponse.getNome());
        assertEquals(descricao, produtoResponse.getDescricao());
        assertEquals(preco, produtoResponse.getPreco());
        assertEquals(categoriaModel.getId(), produtoResponse.getCategoria().getId());
        assertEquals(categoriaModel.getDescricao(), produtoResponse.getCategoria().getDescricao());
    }
}
