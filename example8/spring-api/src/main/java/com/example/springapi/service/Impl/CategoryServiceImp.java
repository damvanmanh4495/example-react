package com.example.springapi.service.Impl;

import com.example.springapi.converter.CategoryConverter;
import com.example.springapi.dto.CategoryDTO;
import com.example.springapi.entity.Category;
import com.example.springapi.entity.Product;
import com.example.springapi.exception.ResourceNotFoundException;
import com.example.springapi.repository.CategoryRepository;
import com.example.springapi.repository.ProductRepository;
import com.example.springapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImp implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryConverter categoryConverter;


    @Override
    public List<CategoryDTO> findByName(String name) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getName().contains(name)) {
                CategoryDTO categoryDTO = categoryConverter.entityToDto(category);
                categoryDTOList.add(categoryDTO);
            }
        }
        return categoryDTOList;
    }

    @Override
    public CategoryDTO findById(int id) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found categories with id :" + id));
        return categoryConverter.entityToDto(category);
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryConverter.dtoToEntity(categoryDTO);
        categoryRepository.save(category);
        return categoryDTO;
    }

    @Transactional
    @Override
    public void deleteById(int id) throws ResourceNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found categories with id :" + id));
        List<Product> products = category.getProducts();
        for (Product product : products) {
            productRepository.deleteById(product.getId());
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAll(int page, int size, String name) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Category> pageResult = categoryRepository.findAll(pageable);
        List<Category> categoryList = pageResult.getContent();
        for (Category category: categoryList) {
            if (category.getName().contains(name)){
                CategoryDTO categoryDTO = categoryConverter.entityToDto(category);
                categoryDTOList.add(categoryDTO);
            }
        }
        return categoryDTOList;
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }


}
