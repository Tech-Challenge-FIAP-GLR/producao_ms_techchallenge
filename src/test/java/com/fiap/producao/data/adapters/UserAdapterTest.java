package com.fiap.producao.data.adapters;

import com.fiap.producao.data.entities.UserEntity;
import com.fiap.producao.data.repositories.UserMongoRepository;
import com.fiap.producao.domain.models.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserAdapterTest {

    @Mock
    private UserMongoRepository userMongoRepository;

    @InjectMocks
    private UserAdapter userAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvar_sucesso() {
        // Arrange
        UserModel userModel = new UserModel();
        userModel.setNome("Nome Teste");
        userModel.setCpf("12345678900");
        userModel.setEmail("teste@teste.com");

        UserEntity userEntity = new UserEntity();
        userEntity.setId("1");

        when(userMongoRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        // Act
        UserModel result = userAdapter.salvar(userModel);

        // Assert
        assertEquals("1", result.getId());
    }

    @Test
    void listaUsuario_sucesso() throws Exception {
        // Arrange
        String id = "1";
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);

        when(userMongoRepository.findById(id)).thenReturn(Optional.of(userEntity));

        // Act
        UserModel result = userAdapter.listaUsuario(id);

        // Assert
        assertEquals(id, result.getId());
    }

    @Test
    void listaUsuario_naoEncontrado() {
        // Arrange
        String id = "1";
        when(userMongoRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> userAdapter.listaUsuario(id));
        assertEquals("Entity not found", exception.getMessage());
    }

    @Test
    void listaUsuariosPorCpf_sucesso() throws Exception {
        // Arrange
        String cpf = "12345678900";
        UserEntity userEntity = new UserEntity();
        userEntity.setCpf(cpf);

        when(userMongoRepository.findByCpf(cpf)).thenReturn(Optional.of(userEntity));

        // Act
        UserModel result = userAdapter.listaUsuariosPorCpf(cpf);

        // Assert
        assertEquals(cpf, result.getCpf());
    }

    @Test
    void listaUsuariosPorCpf_naoEncontrado() {
        // Arrange
        String cpf = "12345678900";
        when(userMongoRepository.findByCpf(cpf)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> userAdapter.listaUsuariosPorCpf(cpf));
        assertEquals("Entity not found", exception.getMessage());
    }

    @Test
    void deletaUser_sucesso() throws Exception {
        // Arrange
        String id = "1";
        doNothing().when(userMongoRepository).deleteById(id);

        // Act
        userAdapter.deletaUser(id);

        // Assert
        verify(userMongoRepository, times(1)).deleteById(id);
    }

    @Test
    void deletaUser_naoEncontrado() {
        // Arrange
        String id = "1";
        doThrow(new RuntimeException("Entity not found")).when(userMongoRepository).deleteById(id);

        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> userAdapter.deletaUser(id));
        assertEquals("Entity not found", exception.getMessage());
    }
}
