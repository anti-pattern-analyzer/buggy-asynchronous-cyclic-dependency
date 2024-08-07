package com.example.service_a;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.c}")
    public void consume(String message) {
        log.info("Service A received the message: {}", message);
    }
}
