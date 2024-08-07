package com.example.service_a;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${rabbitmq.exchange.a}")
    private String aExchange;

    @Value("${rabbitmq.routingKey.a}")
    private String aRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        System.out.printf("Service A message sent to RabbitMQ: %s", message);
        rabbitTemplate.convertAndSend(aExchange, aRoutingKey, message);
    }
}
