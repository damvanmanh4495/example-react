package com.example.demokafka.controller;

import com.example.demokafka.dto.ProductDTO;
import com.example.demokafka.dto.User;
import com.example.demokafka.entity.Product;
import com.example.demokafka.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("kafka")
public class UserResource {
    private final ProductService productService;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example_json";

//    @GetMapping("/publish/{name}")
//    public String post(@PathVariable("name") final String name) {
//        kafkaTemplate.send(TOPIC, new User(name, "Technology", 12000L));
//        return "Published successfully";
//    }

    @GetMapping("/get_product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") Integer id) throws JsonProcessingException {
        ProductDTO productDTO = productService.getProductById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String message = objectMapper.writeValueAsString(productDTO);
        kafkaTemplate.send(TOPIC, message);
        return ResponseEntity.ok().body(productDTO);
    }

}
