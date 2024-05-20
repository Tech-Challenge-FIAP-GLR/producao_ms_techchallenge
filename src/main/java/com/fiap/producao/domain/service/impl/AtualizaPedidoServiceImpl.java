package com.fiap.producao.domain.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.producao.data.dto.OrderStatusDTO;
import com.fiap.producao.domain.service.AtualizaPedidoService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

@Service
public class AtualizaPedidoServiceImpl implements AtualizaPedidoService {
    @Override
    public void atualizaStatusPedido(String id, OrderStatusDTO orderStatusDTO) {
        String putUrl = "http://pedidos-ms-app:3000/api/pedidos/";
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            String putUrlFinal = putUrl+id;
            String json = new ObjectMapper().writeValueAsString(orderStatusDTO);
            HttpEntity<String> entity = new HttpEntity<>(json, headers);
            restTemplate.exchange(putUrlFinal, HttpMethod.PUT, entity, Object.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
