package com.example.service_b;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.a}")
    public void consume(String message) {
        log.info("Service B received the message: {}", message);
    }
}
