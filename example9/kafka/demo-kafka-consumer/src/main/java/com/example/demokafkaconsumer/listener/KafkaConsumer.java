package com.example.demokafkaconsumer.listener;

import com.example.demokafkaconsumer.entity.Product;
import com.example.demokafkaconsumer.repository.ConsumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class KafkaConsumer {
    private final ConsumerRepository consumerRepository;
    private final String TOPIC_message = "kafka_example";
    @KafkaListener(topics = "TOPIC_message", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json",
            containerFactory = "productKafkaListenerFactory")
    public void save(Product product) {
        consumerRepository.save(product);
    }
}
