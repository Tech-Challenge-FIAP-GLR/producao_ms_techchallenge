package com.fiap.producao.core.config;

import com.fiap.producao.data.repositories.UserMongoRepository;
import com.fiap.producao.domain.ports.CategoriaUseCasePort;
import com.fiap.producao.domain.ports.ProdutoUseCasePort;
import com.fiap.producao.domain.ports.UserUseCasePort;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import com.fiap.producao.domain.repositories.ProdutoRepository;
import com.fiap.producao.domain.repositories.UserRepository;
import com.fiap.producao.domain.usecases.CategoriaUseCase;
import com.fiap.producao.domain.usecases.ProdutoUseCase;
import com.fiap.producao.domain.usecases.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {

    @Bean
    public ProdutoUseCasePort produtoUseCase(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
        return new ProdutoUseCase(produtoRepository, categoriaRepository);
    }
    @Bean
    public UserUseCasePort userUseCasePort(UserRepository userRepository){
        return new UserUseCase();
    }

    @Bean
    public CategoriaUseCasePort categoriaUseCase(CategoriaRepository categoriaRepository){
        return new CategoriaUseCase();
    }

}
