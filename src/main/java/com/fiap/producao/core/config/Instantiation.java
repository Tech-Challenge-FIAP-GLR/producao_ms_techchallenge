package com.fiap.producao.core.config;

import com.fiap.producao.data.entities.CategoriaEntity;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    CategoriaMongoRepository categoriaRepository;


    @Override
    public void run(String... args) throws Exception {
        categoriaRepository.deleteAll();

        CategoriaEntity c1 = new CategoriaEntity("1", "Lanche");
        CategoriaEntity c2= new CategoriaEntity("2", "Acompanhamento");
        CategoriaEntity c3 = new CategoriaEntity("3", "Bebida");
        CategoriaEntity c4 = new CategoriaEntity("4", "Sobremesa");

        categoriaRepository.save(c1);
        categoriaRepository.save(c2);
        categoriaRepository.save(c3);
        categoriaRepository.save(c4);
    }
}
