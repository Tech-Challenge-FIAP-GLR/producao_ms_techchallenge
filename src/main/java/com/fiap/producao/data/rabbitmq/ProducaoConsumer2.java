//package com.fiap.producao.data.rabbitmq;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fiap.producao.data.dto.PedidoDTO;
//import com.fiap.producao.domain.service.impl.SalvaPedidoServiceImpl;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ProducaoConsumer2 {
//
//
//    @RabbitListener(queues = {"producao_ms_pedido_finalizado"})
//    public void receive(@Payload String fileBody) {
//
//        final ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            //Recebo O id
//            PedidoDTO pedido = objectMapper.readValue(fileBody, PedidoDTO.class);
//            System.out.println("Message " + fileBody);
//
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//}
