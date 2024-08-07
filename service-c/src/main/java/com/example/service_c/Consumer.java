package com.example.service_c;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {

    @RabbitListener(queues = "${rabbitmq.queue.b}")
    public void consume(String message) {
        log.info("Service C received the message: {}", message);
    }
}
