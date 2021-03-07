package com.example.democonsumer.service;

import com.example.democonsumer.model.Product;
import com.example.democonsumer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }
}
