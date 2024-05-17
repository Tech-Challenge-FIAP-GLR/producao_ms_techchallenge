package com.fiap.producao.data.controllers;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.data.request.ProdutoRequest;
import com.fiap.producao.data.response.ProdutoResponse;
import com.fiap.producao.domain.ports.ProdutoUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Produto", description = "API para gerenciamento de produtos na plataforma")
@RestController
@RequestMapping("api/food_techchallenge/produtos")
public class ProdutoController {

    private final ProdutoUseCasePort produtoUseCasePort;

    public ProdutoController(ProdutoUseCasePort produtoUseCasePort) {
        this.produtoUseCasePort = produtoUseCasePort;
    }

    @Operation(
            summary = "Cria Produto",
            description = "Adiciona um produto ao sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<ProdutoResponse> criaProduto(@Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeSalvar(produtoRequest.toProdutoDomain())));
    }

    @Operation(
            summary = "Atualiza Produto",
            description = "Atualiza as informações de um produto existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> atualizaProduto(@PathVariable String produtoId, @Valid @RequestBody ProdutoRequest produtoRequest){
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeAtualizar(produtoRequest.toProdutoDomain(produtoId))));
    }

    @Operation(
            summary = "Deleta Produto",
            description = "Deleta um produto do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deletaProduto(@PathVariable String produtoId){
        produtoUseCasePort.executeDeletar(produtoId);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Procura Produto",
            description = "Lista um produto com base no seu id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoResponse> recuperaProdutoPorId(@PathVariable String produtoId) throws Exception {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoUseCasePort.executeListar(produtoId)));
    }

    @Operation(
            summary = "Lista Produtos (por Categoria)",
            description = "Lista todos os produtos da categoria selecionada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping("categoria/{descricaoCategoria}")
    public ResponseEntity<List<ProdutoEntity>> recuperaProdutoPorCategoria(@PathVariable String descricaoCategoria) throws Exception {
        return ResponseEntity.ok(produtoUseCasePort.executeListarCategoria(descricaoCategoria));
    }
}
