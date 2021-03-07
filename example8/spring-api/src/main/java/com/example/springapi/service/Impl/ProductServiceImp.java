package com.example.springapi.service.Impl;

import com.example.springapi.converter.ProductConverter;
import com.example.springapi.dto.ProductDTO;
import com.example.springapi.entity.Product;
import com.example.springapi.repository.ProductRepository;
import com.example.springapi.repository.generic.IGenericDao;
import com.example.springapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;
    IGenericDao<Product> dao;

    @Autowired
    public void setDao(IGenericDao<Product> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Product.class);
    }

    @Override
    public List<ProductDTO> findByName(int page, int size, String name) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> pageResult = productRepository.findAll(pageable);
        List<Product> products = pageResult.getContent();
        for (Product product : products) {
            if (product.getName().contains(name)) {
                ProductDTO productDTO = productConverter.entityToDto(product);
                productDTOList.add(productDTO);
            }
        }
        return productDTOList;
    }

    @Override
    public ProductDTO findById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product product = productOptional.get();
        return productConverter.entityToDto(product);
    }

    @Override
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productConverter.dtoToEntity(productDTO);
        productRepository.save(product);
        return productDTO;
    }

    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }


    @Override
    public void deleteAllByCategory(int id) {
        List<Product> products = productRepository.findAll();
        products.removeIf(product -> product.getCategory().getId() == id);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

}
