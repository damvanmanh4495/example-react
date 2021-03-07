package com.example.springapi.converter;

import com.example.springapi.dto.CategoryDTO;
import com.example.springapi.entity.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryConverter {
    public CategoryDTO entityToDto(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setCode(category.getCode());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescriptions(category.getDescriptions());
        categoryDTO.setCreatedNew(category.getCreatedNew());
        categoryDTO.setCreatedEdit(category.getCreatedEdit());
        return categoryDTO;
    }

    public Category dtoToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setCode(categoryDTO.getCode());
        category.setName(categoryDTO.getName());
        category.setDescriptions(categoryDTO.getDescriptions());
        category.setCreatedNew(categoryDTO.getCreatedNew());
        category.setCreatedEdit(categoryDTO.getCreatedEdit());
        return category;
    }

    public List<Category> dtoToEntity(List<CategoryDTO> categoryDTOList) {
        List<Category> categoryList = new ArrayList<>();
        for (CategoryDTO categoryDTO : categoryDTOList) {
            Category category = new Category();
            category.setId(categoryDTO.getId());
            category.setCode(categoryDTO.getCode());
            category.setName(categoryDTO.getName());
            category.setDescriptions(categoryDTO.getDescriptions());
            category.setCreatedNew(categoryDTO.getCreatedNew());
            category.setCreatedEdit(categoryDTO.getCreatedEdit());
            categoryList.add(category);
        }
        return categoryList;
    }

    public List<CategoryDTO> entityToDto(List<Category> categoryList) {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setCode(category.getCode());
            categoryDTO.setName(category.getName());
            categoryDTO.setDescriptions(category.getDescriptions());
            categoryDTO.setCreatedNew(category.getCreatedNew());
            categoryDTO.setCreatedEdit(category.getCreatedEdit());
            categoryDTOList.add(categoryDTO);
        }
        return categoryDTOList;
    }
}
