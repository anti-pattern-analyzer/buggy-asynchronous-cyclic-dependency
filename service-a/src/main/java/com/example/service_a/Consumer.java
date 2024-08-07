package com.example.service_a;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.c}")
    public void consume(String message) {
        System.out.printf("Service A received the message: %s%n", message);
    }
}
