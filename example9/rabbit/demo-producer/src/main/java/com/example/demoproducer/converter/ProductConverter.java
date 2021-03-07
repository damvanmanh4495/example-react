package com.example.demoproducer.converter;

import com.example.demoproducer.dto.ProductDTO;
import com.example.demoproducer.model.Product;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDTO entityToDto(Product product) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product dtoToEntity(ProductDTO productDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(productDTO, Product.class);
    }
}
