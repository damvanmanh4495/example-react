package com.example.springapi.converter;

import com.example.springapi.dto.ProductDTO;
import com.example.springapi.entity.Category;
import com.example.springapi.entity.Inventory;
import com.example.springapi.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    public ProductDTO entityToDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setCode(product.getCode());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setInventoryId(product.getInventory().getId());
        productDTO.setDescriptions(product.getDescriptions());
        productDTO.setNumber(product.getNumber());
        productDTO.setNumberSale(product.getNumberSale());
        productDTO.setCreated(product.getCreated());
        productDTO.setModified(product.getModified());
        return productDTO;
    }

    public Product dtoToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setCode(productDTO.getCode());
        product.setName(productDTO.getName());
        Category category = new Category();
        category.setId(productDTO.getCategoryId());
        product.setCategory(category);
        Inventory inventory = new Inventory();
        inventory.setId(productDTO.getInventoryId());
        product.setInventory(inventory);
        product.setImageLink(productDTO.getImageLink());
        product.setNumber(productDTO.getNumber());
        product.setNumberSale(productDTO.getNumberSale());
        product.setDescriptions(productDTO.getDescriptions());
        product.setCreated(productDTO.getCreated());
        product.setModified(productDTO.getModified());
        return product;
    }

    public List<ProductDTO> entityToDto(List<Product> productList) {
        return productList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public List<Product> dtoToEntity(List<ProductDTO> productDTOList) {
        return productDTOList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }
}
