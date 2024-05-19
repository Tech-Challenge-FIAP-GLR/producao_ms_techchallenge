package com.fiap.producao.data.adapters;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.data.repositories.ProdutoMongoRepository;
import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.models.ProdutoModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoAdapterTest {

    @Mock
    private ProdutoMongoRepository produtoMongoRepository;

    @InjectMocks
    private ProdutoAdapter produtoAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar_sucesso() {
        // Arrange
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setNome("Produto Teste");
        produtoModel.setDescricao("Descrição Teste");
        produtoModel.setPreco(100.00F);
        produtoModel.setCategoriaModel(new CategoriaModel("cat1"));

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId("1");

        when(produtoMongoRepository.save(any(ProdutoEntity.class))).thenReturn(produtoEntity);

        // Act
        ProdutoModel result = produtoAdapter.salvar(produtoModel);

        // Assert
        assertEquals("1", result.getId());
    }

    @Test
    void listaProduto_sucesso() throws Exception {
        // Arrange
        String id = "1";
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId(id);

        when(produtoMongoRepository.findById(id)).thenReturn(Optional.of(produtoEntity));

        // Act
        ProdutoModel result = produtoAdapter.listaProduto(id);

        // Assert
        assertEquals(id, result.getId());
    }

    @Test
    void listaProduto_naoEncontrado() {
        // Arrange
        String id = "1";
        when(produtoMongoRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> produtoAdapter.listaProduto(id));
        assertEquals("Entity not found", exception.getMessage());
    }

    @Test
    void listaProdutoCategoria_sucesso() throws Exception {
        // Arrange
        String categoriaId = "cat1";
        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setCategoriaId(categoriaId);

        when(produtoMongoRepository.findAllByCategoriaId(categoriaId)).thenReturn(List.of(produtoEntity));

        // Act
        List<ProdutoEntity> result = produtoAdapter.listaProdutoCategoria(categoriaId);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(categoriaId, result.get(0).getCategoriaId());
    }




    @Test
    void atualizaProduto_sucesso() {
        // Arrange
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId("1");
        produtoModel.setNome("Produto Atualizado");
        produtoModel.setDescricao("Descrição Atualizada");
        produtoModel.setPreco(200.0F);
        produtoModel.setCategoriaModel(new CategoriaModel("cat1"));

        ProdutoEntity produtoEntity = new ProdutoEntity();
        produtoEntity.setId("1");

        when(produtoMongoRepository.findById("1")).thenReturn(Optional.of(produtoEntity));
        when(produtoMongoRepository.save(any(ProdutoEntity.class))).thenReturn(produtoEntity);

        // Act
        ProdutoModel result = produtoAdapter.atualizaProduto(produtoModel);

        // Assert
        assertEquals("1", result.getId());
        assertEquals("Produto Atualizado", produtoEntity.getNome());
    }

    @Test
    void deletaProduto_sucesso() {
        // Arrange
        String id = "1";
        doNothing().when(produtoMongoRepository).deleteById(id);

        // Act
        produtoAdapter.deletaProduto(id);

        // Assert
        verify(produtoMongoRepository, times(1)).deleteById(id);
    }
}
