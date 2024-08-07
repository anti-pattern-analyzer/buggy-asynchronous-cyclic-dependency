package com.example.service_b;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.a}")
    public void consume(String message) {
        System.out.printf("Service B received the message: %s%n", message);
    }
}
