package com.fiap.producao.core.config;

import com.fiap.producao.domain.ports.UserUseCasePort;
import com.fiap.producao.data.repositories.UserMongoRepository;
import com.fiap.producao.domain.usecases.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {


    @Bean
    @Primary
    public UserUseCasePort userUseCasePort(UserMongoRepository userRepository){
        return new UserUseCase();
    }


}
