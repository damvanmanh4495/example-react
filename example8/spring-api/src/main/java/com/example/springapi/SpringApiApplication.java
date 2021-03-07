package com.example.springapi;

import com.example.springapi.dto.ProductDTO;
import com.example.springapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
@EnableJpaAuditing
public class SpringApiApplication implements CommandLineRunner {
    private final ProductService productService;


    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
