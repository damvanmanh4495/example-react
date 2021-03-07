package com.example.democonsumer.consumer;


import com.example.democonsumer.model.Product;
import com.example.democonsumer.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RabbitMQConsumer {

    private final ProductService productService;

    @RabbitListener(queues = "${javainuse.rabbitmq.queue}")
    public void receivedMessage(Product product) {
        System.out.println("Recieved Message From RabbitMQ: " + product);
        productService.save(product);
    }
}
