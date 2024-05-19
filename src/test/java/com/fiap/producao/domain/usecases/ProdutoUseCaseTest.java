package com.fiap.producao.domain.usecases;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.models.ProdutoModel;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import com.fiap.producao.domain.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProdutoUseCaseTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private ProdutoUseCase produtoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecuteSalvar() {
        // Arrange
        String categoriaId = "cat123";
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setCategoriaModel(new CategoriaModel(categoriaId));
        when(categoriaRepository.listarCategoriaById(categoriaId)).thenReturn(new CategoriaModel(categoriaId));
        when(produtoRepository.salvar(produtoModel)).thenReturn(produtoModel);

        // Act
        ProdutoModel result = produtoUseCase.executeSalvar(produtoModel);

        // Assert
        assertEquals(categoriaId, result.getCategoriaModel().getId());
        verify(categoriaRepository, times(1)).listarCategoriaById(categoriaId);
        verify(produtoRepository, times(1)).salvar(produtoModel);
    }

//    @Test
//    void testExecuteListar() throws Exception {
//        // Arrange
//        String produtoId = "prod123";
//        ProdutoModel produtoModel = new ProdutoModel();
//        produtoModel.setId(produtoId);
//        when(produtoRepository.listaProduto(produtoId)).thenReturn(produtoModel);
//
//        // Act
//        ProdutoModel result = produtoUseCase.executeListar(produtoId);
//
//        // Assert
//        assertEquals(produtoId, result.getId());
//        verify(produtoRepository, times(1)).listaProduto(produtoId);
//    }

    @Test
    void testExecuteListarCategoria() throws Exception {
        // Arrange
        String descricaoCategoria = "Categoria Teste";
        String categoriaId = "cat123";
        CategoriaModel categoriaModel = new CategoriaModel(categoriaId);
        when(categoriaRepository.listarCategoriaByDescricao(descricaoCategoria)).thenReturn(categoriaModel);
        List<ProdutoEntity> produtos = new ArrayList<>();
        when(produtoRepository.listaProdutoCategoria(categoriaId)).thenReturn(produtos);

        // Act
        List<ProdutoEntity> result = produtoUseCase.executeListarCategoria(descricaoCategoria);

        // Assert
        assertEquals(produtos, result);
        verify(categoriaRepository, times(1)).listarCategoriaByDescricao(descricaoCategoria);
        verify(produtoRepository, times(1)).listaProdutoCategoria(categoriaId);
    }

    @Test
    void testExecuteAtualizar() {
        // Arrange
        String categoriaId = "cat123";
        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setCategoriaModel(new CategoriaModel(categoriaId));
        when(categoriaRepository.listarCategoriaById(categoriaId)).thenReturn(new CategoriaModel(categoriaId));
        when(produtoRepository.atualizaProduto(produtoModel)).thenReturn(produtoModel);

        // Act
        ProdutoModel result = produtoUseCase.executeAtualizar(produtoModel);

        // Assert
        assertEquals(categoriaId, result.getCategoriaModel().getId());
        verify(categoriaRepository, times(1)).listarCategoriaById(categoriaId);
        verify(produtoRepository, times(1)).atualizaProduto(produtoModel);
    }

    @Test
    void testExecuteDeletar() {
        // Arrange
        String produtoId = "prod123";

        // Act
        produtoUseCase.executeDeletar(produtoId);

        // Assert
        verify(produtoRepository, times(1)).deletaProduto(produtoId);
    }
}
