package com.fiap.producao.domain.service;

import com.fiap.producao.data.dto.OrderStatusDTO;

public interface AtualizaPedidoService {
    void atualizaStatusPedido(String id, OrderStatusDTO orderStatusDTO);
}
