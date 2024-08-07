package com.example.service_c;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
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
        log.info("Service C message sent to RabbitMQ: {}", message);
        rabbitTemplate.convertAndSend(cExchange, cRoutingKey, message);
    }
}
