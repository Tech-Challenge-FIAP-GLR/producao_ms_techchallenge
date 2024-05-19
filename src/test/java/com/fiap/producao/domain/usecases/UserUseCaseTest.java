package com.fiap.producao.domain.usecases;

import com.fiap.producao.domain.models.UserModel;
import com.fiap.producao.domain.repositories.UserRepository;
import com.fiap.producao.domain.ports.UserUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserUseCase userUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSalvar() {
        // Arrange
        UserModel userModel = new UserModel();
        when(userRepository.salvar(userModel)).thenReturn(userModel);

        // Act
        UserModel result = userUseCase.salvar(userModel);

        // Assert
        assertEquals(userModel, result);
        verify(userRepository, times(1)).salvar(userModel);
    }

    @Test
    void testListaUsuarios() throws Exception {
        // Arrange
        String userId = "user123";
        UserModel userModel = new UserModel();
        userModel.setId(userId);
        when(userRepository.listaUsuario(userId)).thenReturn(userModel);

        // Act
        UserModel result = userUseCase.listaUsuarios(userId);

        // Assert
        assertEquals(userId, result.getId());
        verify(userRepository, times(1)).listaUsuario(userId);
    }

    @Test
    void testListaUsuariosPorCpf() throws Exception {
        // Arrange
        String cpf = "123456789";
        UserModel userModel = new UserModel();
        when(userRepository.listaUsuariosPorCpf(cpf)).thenReturn(userModel);

        // Act
        UserModel result = userUseCase.listaUsuariosPorCpf(cpf);

        // Assert
        assertEquals(userModel, result);
        verify(userRepository, times(1)).listaUsuariosPorCpf(cpf);
    }

    @Test
    void testDeletaUser() throws Exception {
        // Arrange
        String userId = "user123";

        // Act
        userUseCase.deletaUser(userId);

        // Assert
        verify(userRepository, times(1)).deletaUser(userId);
    }
}
