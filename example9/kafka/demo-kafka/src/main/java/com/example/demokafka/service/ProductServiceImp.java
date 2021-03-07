package com.example.demokafka.service;

import com.example.demokafka.dto.ProductDTO;
import com.example.demokafka.entity.Product;
import com.example.demokafka.mapper.ProductConverter;
import com.example.demokafka.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDTO getProductById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();
        ProductDTO productDTO = productConverter.entityToDto(product);
        return productDTO;
    }
}
