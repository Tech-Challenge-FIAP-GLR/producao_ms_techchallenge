package com.fiap.producao.data.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.data.entities.PagamentoEntity;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import com.fiap.producao.data.repositories.PedidoMongoRepository;
import com.fiap.producao.domain.service.impl.SalvaPedidoServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.domain.service.impl.SalvaPedidoServiceImpl;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProducaoConsumer {

    @Autowired
    SalvaPedidoServiceImpl salvaPedidoService;

    @Autowired
    ProducaoProducer producaoProducer;

    @RabbitListener(queues = "pagamentos_ms_producao_success")
    public void receive(@Payload String fileBody) {

        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            PagamentoEntity pedido = objectMapper.readValue(fileBody, PagamentoEntity.class);
            pedido.setOrderStatus("FINALIZADO");

            salvaPedidoService.salvarPedido(pedido);

            producaoProducer.send(objectMapper.writeValueAsString(pedido), "pedido_finalizado");

            System.out.println("Message " + objectMapper.writeValueAsString(pedido));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}