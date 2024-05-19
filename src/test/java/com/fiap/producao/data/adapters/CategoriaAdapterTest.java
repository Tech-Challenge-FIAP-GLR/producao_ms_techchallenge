package com.fiap.producao.data.adapters;

import com.fiap.producao.data.entities.CategoriaEntity;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import com.fiap.producao.domain.models.CategoriaModel;
import jakarta.persistence.NoResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoriaAdapterTest {

    @Mock
    private CategoriaMongoRepository categoriaMongoRepository;

    @InjectMocks
    private CategoriaAdapter categoriaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCategoriaById_sucesso() {
        // Arrange
        String id = "123";
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(id);
        when(categoriaMongoRepository.findById(id)).thenReturn(Optional.of(categoriaEntity));
        CategoriaModel expectedCategoriaModel = CategoriaModel.fromEntity(categoriaEntity);

        // Act
        CategoriaModel result = categoriaAdapter.listarCategoriaById(id);

        // Assert
        assertEquals(expectedCategoriaModel.getClass(), CategoriaModel.class);
    }

    @Test
    void listarCategoriaById_naoEncontrado() {
        // Arrange
        String id = "123";
        when(categoriaMongoRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoResultException.class, () -> categoriaAdapter.listarCategoriaById(id));
    }

    @Test
    void listarCategoriaByDescricao_sucesso() {
        // Arrange
        String descricao = "categoria 1";
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setDescricao(descricao);
        when(categoriaMongoRepository.findByDescricao(descricao)).thenReturn(categoriaEntity);
        CategoriaModel expectedCategoriaModel = CategoriaModel.fromEntity(categoriaEntity);

        // Act
        CategoriaModel result = categoriaAdapter.listarCategoriaByDescricao(descricao);

        // Assert
        assertEquals(expectedCategoriaModel.getClass(), CategoriaModel.class);
    }

    @Test
    void listarCategoriaByDescricao_naoEncontrado() {
        // Arrange
        String descricao = "categoria 1";
        when(categoriaMongoRepository.findByDescricao(descricao)).thenReturn(null);

        // Act & Assert
        assertThrows(NoResultException.class, () -> categoriaAdapter.listarCategoriaByDescricao(descricao));
    }
}
