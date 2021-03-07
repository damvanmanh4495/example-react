package com.example.demoproducer.controller;

import com.example.demoproducer.dto.ProductDTO;
import com.example.demoproducer.service.ProductService;
import com.example.demoproducer.service.RabbitMQSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

    private final RabbitMQSender rabbitMQSender;
    private final ProductService productService;

//    @GetMapping(value = "/producer")
//    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {
//
//        Employee emp=new Employee();
//        emp.setEmpId(empId);
//        emp.setEmpName(empName);
//        rabbitMQSender.send(emp);
//
//        return "Message sent to the RabbitMQ JavaInUse Successfully";
//    }

    @PostMapping("/get_product/{id}")
    public ResponseEntity<ProductDTO> sendProduct(@PathVariable(value = "id") Integer id) {
        ProductDTO productDTO = productService.getProductById(id);
        rabbitMQSender.send(productDTO);

        return ResponseEntity.ok().body(productDTO);
    }
}