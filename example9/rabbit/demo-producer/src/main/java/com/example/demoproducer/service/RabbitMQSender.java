package com.example.demoproducer.service;

import com.example.demoproducer.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;

    @Value("${javainuse.rabbitmq.exchange}")
    private String exchange;

    @Value("${javainuse.rabbitmq.routingkey}")
    private String routingkey;

    public void send(ProductDTO productDTO) {
        rabbitTemplate.convertAndSend(exchange, routingkey, productDTO);
        System.out.println("Send msg = " + productDTO);

    }
}