package com.fiap.producao.domain.service;

import com.fiap.producao.data.dto.OrderStatusDTO;
import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.data.entities.PagamentoEntity;

import java.util.Optional;

public interface SalvaPedidoService {
    PagamentoEntity salvarPedido(PagamentoEntity pedido);
}
