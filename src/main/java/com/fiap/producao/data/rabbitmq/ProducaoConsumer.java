package com.fiap.producao.data.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.producao.data.dto.PedidoDTO;
import com.fiap.producao.data.repositories.CategoriaMongoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProducaoConsumer {

//    @Autowired
//    PedidoMongoRepository pedidoMongoRepository;

    @Autowired
    ProducaoProducer producaoProducer;

    @RabbitListener(queues = {"pagamentos_ms_pedido_success"})
    public void receive(@Payload String fileBody) {

        final ObjectMapper objectMapper = new ObjectMapper();



        try {
            //Recebo a MSG
            PedidoDTO pedido = objectMapper.readValue(fileBody, PedidoDTO.class);
            //SALVO
            //pedidoMongoRepository.salvarPedido(pedido);

            //Posto
            producaoProducer.send("pedido_finalizado", fileBody);




        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        //Recebo a msg,

        //transformo e Json(checar se tenho que atualizar status)

        //Posto na proxima fila
        System.out.println("Message " + fileBody);

    }
}
