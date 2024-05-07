package com.fiap.producao.data.adapters;


import com.fiap.producao.data.entities.CategoriaEntity;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import com.fiap.producao.domain.models.CategoriaModel;
import com.fiap.producao.domain.repositories.CategoriaRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Component;

@Component
public class CategoriaAdapter implements CategoriaRepository {

    private final CategoriaMongoRepository categoriaMongoRepository;

    public CategoriaAdapter(CategoriaMongoRepository categoriaMongoRepository) {
        this.categoriaMongoRepository = categoriaMongoRepository;
    }

    @Override
    public CategoriaModel listarCategoriaById(String id) {
        try {
            var categoriaEntity = categoriaMongoRepository.findById(id);
            return CategoriaModel.fromEntity(categoriaEntity.get());
        } catch(Exception exception) {
            throw new NoResultException();
        }
    }

    @Override
    public CategoriaModel listarCategoriaByDescricao(String descricao) {
        try {
            var categoriaEntity = categoriaMongoRepository.findByDescricao(descricao);
            return CategoriaModel.fromEntity((CategoriaEntity) categoriaEntity);
        } catch(Exception exception) {
            throw new NoResultException();
        }
    }

}
