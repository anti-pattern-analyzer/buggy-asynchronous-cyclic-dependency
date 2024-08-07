package com.example.service_a;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    private final Producer producer;

    public Controller(Producer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage() {
        producer.sendMessage("Message from Service A");
        return ResponseEntity.ok("Message sent to the RabbitMQ");
    }
}
