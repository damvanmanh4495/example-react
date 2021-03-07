package com.example.springapi.service;

import com.example.springapi.dto.CategoryDTO;
import com.example.springapi.entity.Category;
import com.example.springapi.exception.ResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> findByName(String name);

    CategoryDTO findById(int id) throws ResourceNotFoundException;

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    void deleteById(int id) throws ResourceNotFoundException;

    List<CategoryDTO> getAll(int page, int size, String name);

    long count();
}
