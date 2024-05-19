package com.fiap.producao.domain.usecases;

import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaUseCaseTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaUseCase categoriaUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testExecuteId() {
        // Arrange
        String id = "cat123";
        CategoriaModel expectedCategoria = new CategoriaModel();
        expectedCategoria.setId(id);
        when(categoriaRepository.listarCategoriaById(id)).thenReturn(expectedCategoria);

        // Act
        CategoriaModel result = categoriaUseCase.executeId(id);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(categoriaRepository, times(1)).listarCategoriaById(id);
    }

    @Test
    void testExecute() {
        // Arrange
        String descricao = "Categoria Teste";
        CategoriaModel expectedCategoria = new CategoriaModel();
        expectedCategoria.setDescricao(descricao);
        when(categoriaRepository.listarCategoriaByDescricao(descricao)).thenReturn(expectedCategoria);

        // Act
        CategoriaModel result = categoriaUseCase.execute(descricao);

        // Assert
        assertNotNull(result);
        assertEquals(descricao, result.getDescricao());
        verify(categoriaRepository, times(1)).listarCategoriaByDescricao(descricao);
    }
}
