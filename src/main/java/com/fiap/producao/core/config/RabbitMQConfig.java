package com.fiap.producao.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {


    @Bean
    public Queue testeQueue() {
        return new Queue("pagamentos_ms_pedido_success", true);
    }
    @Bean
    public Queue testeQueue3() {
        return new Queue("pagamentos_ms_pedido_success", true);
    }


    @Bean
    DirectExchange exchange() {
        return new DirectExchange("pagamentos_ms_exchange");
    }

    @Bean
    public Queue testeQueue2() {
        return new Queue("producao_ms_pedido_finalizado", true);
    }

    @Bean
    DirectExchange exchange2() {
        return new DirectExchange("producao_ms_exchange");
    }

    @Bean
    Binding testeBinding(Queue testeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(testeQueue).to(exchange).with("success");
    }

}
