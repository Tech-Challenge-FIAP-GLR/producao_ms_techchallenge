package com.fiap.producao.data.controllers;

import com.fiap.producao.data.request.UserRequest;
import com.fiap.producao.data.response.UserResponse;
import com.fiap.producao.domain.models.UserModel;
import com.fiap.producao.domain.ports.UserUseCasePort;
import com.fiap.producao.domain.repositories.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    @Mock
    private UserUseCasePort userUseCasePort;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriaUsuario() {

        UserModel userModel = new UserModel();
        userModel.setId("1");
        userModel.setCpf("231");
        userModel.setNome("Loira");
        userModel.setEmail("loira@yahoo.com");

        when(userUseCasePort.salvar(any(UserModel.class))).thenReturn(userModel);

        UserRequest request = new UserRequest();
        request.setCpf("231");
        request.setNome("Loira");
        request.setEmail("loira@yahoo.com");

        ResponseEntity<UserResponse> responseEntity = userController.criaUsuario(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userUseCasePort, times(1)).salvar(any(UserModel.class));
    }

    @Test
    void testGetUsuario() throws Exception {
        String userId = "1";
        UserModel userModel = new UserModel();
        when(userUseCasePort.listaUsuarios(userId)).thenReturn(userModel);

        ResponseEntity<UserResponse> responseEntity = userController.getUsuario(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userUseCasePort, times(1)).listaUsuarios(userId);
    }

    @Test
    void testGetUsuarioPorCpf() throws Exception {
        String cpf = "12345678900";
        UserModel userModel = new UserModel();
        when(userUseCasePort.listaUsuariosPorCpf(cpf)).thenReturn(userModel);

        ResponseEntity<UserResponse> responseEntity = userController.getUsuarioPorCpf(cpf);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userUseCasePort, times(1)).listaUsuariosPorCpf(cpf);
    }

    @Test
    void testDeletaUsuario() throws Exception {
        String userId = "1";

        ResponseEntity<String> responseEntity = userController.deletaUsuario(userId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(userUseCasePort, times(1)).deletaUser(userId);
    }
}