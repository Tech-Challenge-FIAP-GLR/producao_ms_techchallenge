package com.fiap.producao.domain.service.impl;

import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.data.entities.PagamentoEntity;
import com.fiap.producao.data.repositories.PedidoMongoRepository;
import com.fiap.producao.domain.service.SalvaPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalvaPedidoServiceImpl implements SalvaPedidoService {
    @Autowired
    PedidoMongoRepository pedidoMongoRepository;
    @Override
    public PagamentoEntity salvarPedido(PagamentoEntity pedido) {

        return pedidoMongoRepository.save(pedido);
    }
}
