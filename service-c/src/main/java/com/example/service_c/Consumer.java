package com.example.service_c;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.b}")
    public void consume(String message) {
        System.out.printf("Service C received the message: %s%n", message);
    }
}
