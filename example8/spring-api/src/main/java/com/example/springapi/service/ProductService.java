package com.example.springapi.service;

import com.example.springapi.dto.ProductDTO;
import com.example.springapi.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findByName(int page, int size, String name);

    ProductDTO findById(int id);

    ProductDTO addProduct(ProductDTO productDTO);

    void deleteById(int id);

    void deleteAllByCategory(int id);

    List<Product> findAll();

}
