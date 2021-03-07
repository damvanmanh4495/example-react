package com.example.demorabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @RabbitListener(queues = "queue.ex")
    public void receiveMessage(String message) {
        System.out.println("Received Message:" + message);
        System.out.println();
    }

//    @RabbitListener(queues = "queue_name")
//    public void receiveMessage2(String message) {
//        System.out.println("Received Message:" + message.get);
//        System.out.println();
//    }

}
