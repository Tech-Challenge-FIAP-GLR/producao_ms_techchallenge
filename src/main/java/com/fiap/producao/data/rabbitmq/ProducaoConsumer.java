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
public class ProducaoConsumer implements ChannelAwareMessageListener {

    @Autowired
    SalvaPedidoServiceImpl salvaPedidoService;

    @Autowired
    ProducaoProducer producaoProducer;

    @Override
    @RabbitListener(queues = "pagamentos_ms_producao_success")
    public void onMessage(Message message, Channel channel) throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            String fileBody = new String(message.getBody());
            PagamentoEntity pedido = objectMapper.readValue(fileBody, PagamentoEntity.class);
            pedido.setOrderStatus("FINALIZADO");

            salvaPedidoService.salvarPedido(pedido);

            producaoProducer.send(objectMapper.writeValueAsString(pedido), "pedido_finalizado");

            System.out.println("Message " + objectMapper.writeValueAsString(pedido));

            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (JsonProcessingException e) {
            // Rejeita a mensagem e não reencaminha para a fila
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
            throw new RuntimeException(e);
        }
    }
}