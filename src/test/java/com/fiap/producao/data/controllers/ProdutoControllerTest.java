package com.fiap.producao.data.controllers;

import com.fiap.producao.data.entities.ProdutoEntity;
import com.fiap.producao.data.request.ProdutoRequest;
import com.fiap.producao.data.response.ProdutoResponse;
import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.models.ProdutoModel;
import com.fiap.producao.domain.ports.ProdutoUseCasePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProdutoControllerTest {

    @Mock
    private ProdutoUseCasePort produtoUseCasePort;

    @InjectMocks
    private ProdutoController produtoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCriaProduto() {
        ProdutoRequest request = new ProdutoRequest();
        ProdutoEntity produtoEntity = new ProdutoEntity();

        ProdutoModel produtoModel = new ProdutoModel();
        produtoModel.setId("1");
        produtoModel.setNome("Produto Teste");
        produtoModel.setDescricao("Descrição do Produto Teste");
        produtoModel.setPreco(10.0f);

        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId("1");
        categoriaModel.setDescricao("Descrição da Categoria Teste");
        produtoModel.setCategoriaModel(categoriaModel);

        when(produtoUseCasePort.executeSalvar(any())).thenReturn(produtoModel);

        ResponseEntity<ProdutoResponse> responseEntity = produtoController.criaProduto(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(produtoUseCasePort, times(1)).executeSalvar(any());
    }

//    @Test
//    void testAtualizaProduto() {
//        String produtoId = "1";
//        ProdutoRequest request = new ProdutoRequest();
//        ProdutoEntity produtoEntity = new ProdutoEntity();
//
//        // Configura o mock para retornar um ProdutoModel simulado ao chamar executeAtualizar
//        when(produtoUseCasePort.executeAtualizar(any(ProdutoModel.class))).thenReturn(ProdutoModel.fromEntity(produtoEntity));
//
//        ResponseEntity<ProdutoResponse> responseEntity = produtoController.atualizaProduto(produtoId, request);
//
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//        verify(produtoUseCasePort, times(1)).executeAtualizar(any(ProdutoModel.class));
//    }

    @Test
    void testDeletaProduto() {
        String produtoId = "1";

        ResponseEntity<Void> responseEntity = produtoController.deletaProduto(produtoId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(produtoUseCasePort, times(1)).executeDeletar(produtoId);
    }

    @Test
    void testRecuperaProdutoPorId() throws Exception {
        String produtoId = "1";
        ProdutoEntity produtoEntity = new ProdutoEntity();
        when(produtoUseCasePort.executeListar(produtoId)).thenReturn(ProdutoModel.fromEntity(produtoEntity));

        ResponseEntity<ProdutoResponse> responseEntity = produtoController.recuperaProdutoPorId(produtoId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(produtoUseCasePort, times(1)).executeListar(produtoId);
    }

    @Test
    void testRecuperaProdutoPorCategoria() throws Exception {
        String descricaoCategoria = "Categoria";
        List<ProdutoEntity> produtos = new ArrayList<>();
        when(produtoUseCasePort.executeListarCategoria(descricaoCategoria)).thenReturn(produtos);

        ResponseEntity<List<ProdutoEntity>> responseEntity = produtoController.recuperaProdutoPorCategoria(descricaoCategoria);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(produtoUseCasePort, times(1)).executeListarCategoria(descricaoCategoria);
    }
}