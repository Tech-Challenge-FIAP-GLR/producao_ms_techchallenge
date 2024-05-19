package com.fiap.producao.data.response;

import com.fiap.producao.domain.models.CategoriaModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoriaResponseTest {

    @Test
    void testFromDomain() {
        // Arrange
        String id = "1";
        String descricao = "Categoria Teste";
        CategoriaModel categoriaModel = new CategoriaModel(id, descricao);

        // Act
        CategoriaResponse categoriaResponse = CategoriaResponse.fromDomain(categoriaModel);

        // Assert
        assertEquals(id, categoriaResponse.getId());
        assertEquals(descricao, categoriaResponse.getDescricao());
    }
}
