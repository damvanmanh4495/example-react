package com.example.demokafka.service;

import com.example.demokafka.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductById(int id);
}
