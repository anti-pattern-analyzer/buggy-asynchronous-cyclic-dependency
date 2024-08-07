package com.example.service_b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    @Value("${rabbitmq.exchange.b}")
    private String aExchange;

    @Value("${rabbitmq.routingKey.b}")
    private String aRoutingKey;

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        log.info("Service B message sent to RabbitMQ: {}", message);
        rabbitTemplate.convertAndSend(aExchange, aRoutingKey, message);
    }
}
