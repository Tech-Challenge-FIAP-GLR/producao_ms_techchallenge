package com.fiap.producao.domain.service;

import com.fiap.producao.data.dto.OrderStatusDTO;
import com.fiap.producao.data.dto.PedidoDTO;

import java.util.Optional;

public interface SalvaPedidoService {
    PedidoDTO salvarPedido(PedidoDTO pedido);
}
