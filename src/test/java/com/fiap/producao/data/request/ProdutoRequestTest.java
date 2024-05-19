//package com.fiap.producao.data.request;
//
//import com.fiap.producao.domain.models.CategoriaModel;
//import com.fiap.producao.domain.models.ProdutoModel;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import jakarta.validation.ValidatorFactory;
//
//import java.util.Set;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ProdutoRequestTest {
//
//    private Validator validator;
//
//    @BeforeEach
//    void setUp() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        validator = factory.getValidator();
//    }
//
//    @Test
//    void toProdutoDomain_sucesso() {
//        // Arrange
//        ProdutoRequest produtoRequest = new ProdutoRequest();
//        produtoRequest.setNome("Produto Teste");
//        produtoRequest.setDescricao("Descrição Teste");
//        produtoRequest.setPreco(100.0f);
//        produtoRequest.setCategoriaId("cat123");
//
//        // Act
//        ProdutoModel produtoModel = produtoRequest.toProdutoDomain();
//
//        // Assert
//        assertNotNull(produtoModel);
//        assertEquals("Produto Teste", produtoModel.getNome());
//        assertEquals("Descrição Teste", produtoModel.getDescricao());
//        assertEquals(100.0f, produtoModel.getPreco());
//        assertEquals("cat123", produtoModel.getCategoriaModel().getId());
//    }
//
//    @Test
//    void toProdutoDomain_comId_sucesso() {
//        // Arrange
//        ProdutoRequest produtoRequest = new ProdutoRequest();
//        produtoRequest.setNome("Produto Teste");
//        produtoRequest.setDescricao("Descrição Teste");
//        produtoRequest.setPreco(100.0f);
//        produtoRequest.setCategoriaId("cat123");
//        String id = "prod123";
//
//        // Act
//        ProdutoModel produtoModel = produtoRequest.toProdutoDomain(id);
//
//        // Assert
//        assertNotNull(produtoModel);
//        assertEquals("prod123", produtoModel.getId());
//        assertEquals("Produto Teste", produtoModel.getNome());
//        assertEquals("Descrição Teste", produtoModel.getDescricao());
//        assertEquals(100.0f, produtoModel.getPreco());
//        assertEquals("cat123", produtoModel.getCategoriaModel().getId());
//    }
//
//    @Test
//    void validarProdutoRequestCamposObrigatorios() {
//        // Arrange
//        ProdutoRequest produtoRequest = new ProdutoRequest();
//
//        // Act
//        Set<ConstraintViolation<ProdutoRequest>> violations = validator.validate(produtoRequest);
//
//        // Assert
//        assertFalse(violations.isEmpty());
//        assertEquals(4, violations.size()); // Todos os campos são obrigatórios e devem estar ausentes
//
//        for (ConstraintViolation<ProdutoRequest> violation : violations) {
//            String propertyPath = violation.getPropertyPath().toString();
//            if (propertyPath.equals("nome")) {
//                assertEquals("must not be empty", violation.getMessage());
//            } else if (propertyPath.equals("descricao")) {
//                assertEquals("must not be empty", violation.getMessage());
//            } else if (propertyPath.equals("preco")) {
//                assertEquals("must not be null", violation.getMessage());
//            } else if (propertyPath.equals("categoriaId")) {
//                assertEquals("must not be null", violation.getMessage());
//            }
//        }
//    }
//
//    @Test
//    void validarProdutoRequestComValoresValidos() {
//        // Arrange
//        ProdutoRequest produtoRequest = new ProdutoRequest();
//        produtoRequest.setNome("Produto Teste");
//        produtoRequest.setDescricao("Descrição Teste");
//        produtoRequest.setPreco(100.0f);
//        produtoRequest.setCategoriaId("cat123");
//
//        // Act
//        Set<ConstraintViolation<ProdutoRequest>> violations = validator.validate(produtoRequest);
//
//        // Assert
//        assertTrue(violations.isEmpty());
//    }
//}
