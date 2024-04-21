package com.fiap.producao.controllers;

import com.fiap.producao.models.UserModel;
import com.fiap.producao.ports.UserUseCasePort;
import com.fiap.producao.request.UserRequest;
import com.fiap.producao.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Usuário", description = "API para gerenciamento de usuários na plataforma")
@RestController
@RequestMapping("api/food_techchallenge/users")
public class UserController {

    private final UserUseCasePort userUseCasePort;

    public UserController(UserUseCasePort userUseCasePort) {
        this.userUseCasePort = userUseCasePort;
    }

    @Operation(
            summary = "Cria Usuário",
            description = "Adiciona um usuário ao sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<UserResponse> criaUsuario(@RequestBody UserRequest userRequest) {
        UserModel userModel = userRequest.toUserDomain();
        UserResponse userResponse = UserResponse.fromDomain(userUseCasePort.salvar(userModel));
        return ResponseEntity.ok(userResponse);
    }

    @Operation(
            summary = "Procura Usuário",
            description = "Lista um usuário com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUsuario(@PathVariable Long userId) throws Exception {
        return ResponseEntity.ok(UserResponse.fromDomain(userUseCasePort.listaUsuarios(userId)));
    }

}
