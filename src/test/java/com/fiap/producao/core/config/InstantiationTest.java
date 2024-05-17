package com.fiap.producao.core.config;

import com.fiap.producao.data.entities.CategoriaEntity;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class InstantiationTest {

    @Autowired
    private Instantiation instantiation;

    @MockBean
    private CategoriaMongoRepository categoriaRepositoryMock;

    @BeforeEach
    public void setup() {
        // Configuração de comportamento do mock
        Mockito.when(categoriaRepositoryMock.save(Mockito.any(CategoriaEntity.class)))
                .thenReturn(new CategoriaEntity("1", "Lanche"));
    }

    @Test
    public void testRun() throws Exception {
        // Executa o método run
        instantiation.run();

        // Verifica se o método deleteAll foi chamado
        Mockito.verify(categoriaRepositoryMock, Mockito.times(2)).deleteAll();

        // Verifica se o método save foi chamado quatro vezes (para cada entidade)
        Mockito.verify(categoriaRepositoryMock, Mockito.times(8)).save(Mockito.any(CategoriaEntity.class));
    }
}