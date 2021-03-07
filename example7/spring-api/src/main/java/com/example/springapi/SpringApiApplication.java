package com.example.springapi;

import com.example.springapi.dto.ProductDTO;
import com.example.springapi.entity.User;
import com.example.springapi.repository.CategoryRepository;
import com.example.springapi.repository.ProductRepository;
import com.example.springapi.entity.Category;
import com.example.springapi.entity.Inventory;
import com.example.springapi.entity.Product;
import com.example.springapi.repository.UserRepository;
import com.example.springapi.service.CategoryDAOtestService;
import com.example.springapi.service.CategoryService;
import com.example.springapi.service.InventoryService;
import com.example.springapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner {
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;
    private final InventoryService inventoryService;
    private final CategoryDAOtestService categoryDAOtestService;
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringApiApplication.class, args);
    }

    @Override
    public void run(String... args) {

        ProductDTO productDTO = productService.findById(1);
        System.out.println(productDTO.getInventoryId()+ productDTO.getName());

    }
}
