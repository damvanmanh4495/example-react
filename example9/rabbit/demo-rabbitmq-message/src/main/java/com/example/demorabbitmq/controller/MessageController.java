package com.example.demorabbitmq.controller;

import com.example.demorabbitmq.model.Message;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    String QUEUE_NAME = "queue.ex";

    private static final String EXCHANGE_NAME = "fanout.ex";

    String ROUTING_KEY = "rabbitmq.*";
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public MessageController(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

//    @GetMapping("/send_message")
//    public String sendMessage() {
//        amqpTemplate.convertAndSend("fanout.ex", "", "Sample message using amqp template");
//        return "Message Sent";
//    }

    @PostMapping("/send_message")
    public void sendMessage(@RequestBody Message message) {
        amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message.getMessage());
    }
}
