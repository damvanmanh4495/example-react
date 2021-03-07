package com.example.demoproducer.service;

import com.example.demoproducer.converter.ProductConverter;
import com.example.demoproducer.dto.ProductDTO;
import com.example.demoproducer.model.Product;
import com.example.demoproducer.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
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
