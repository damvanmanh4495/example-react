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
        productDTO.setCreatedNew(product.getCreatedNew());
        productDTO.setCreatedEdit(product.getCreatedEdit());
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
        product.setCreatedNew(productDTO.getCreatedNew());
        product.setCreatedEdit(productDTO.getCreatedEdit());
        return product;
    }

    public List<ProductDTO> entityToDto(List<Product> productList) {
        return productList.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public List<Product> dtoToEntity(List<ProductDTO> productDTOList) {
        return productDTOList.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
