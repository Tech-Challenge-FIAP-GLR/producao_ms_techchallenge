package com.fiap.producao.data.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducaoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String message, String key) {
        rabbitTemplate.convertAndSend("producao_ms_exchange", key, message);
    }

}
