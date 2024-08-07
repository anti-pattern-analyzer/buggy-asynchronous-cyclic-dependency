package com.example.service_c;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${rabbitmq.exchange.c}")
    private String cExchange;

    @Value("${rabbitmq.routingKey.c}")
    private String cRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        System.out.printf("Service C message sent to RabbitMQ: %s%n", message);
        rabbitTemplate.convertAndSend(cExchange, cRoutingKey, message);
    }
}
