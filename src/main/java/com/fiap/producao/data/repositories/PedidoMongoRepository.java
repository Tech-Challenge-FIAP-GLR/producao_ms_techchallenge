package com.fiap.producao.data.repositories;

import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.data.entities.UserEntity;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Hidden
public interface PedidoMongoRepository extends MongoRepository<PedidoDTO, String> {
//    PedidoDTO salvarPedido(PedidoDTO pedido);
}
