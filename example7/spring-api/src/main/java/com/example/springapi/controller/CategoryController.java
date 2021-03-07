package com.example.springapi.controller;

import com.example.springapi.converter.CategoryConverter;
import com.example.springapi.dto.CategoryDTO;
import com.example.springapi.exception.ResourceNotFoundException;
import com.example.springapi.service.CategoryService;
import com.example.springapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin/")
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping(value = "/categories/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        CategoryDTO categoryDTO = categoryService.findById(id);
        if (categoryDTO == null) {
            throw new ResourceNotFoundException("Not found Category with: " + id);
        } else {
            return ResponseEntity.ok().body(categoryDTO);
        }
    }

    @PutMapping(value = "/categories/{id}")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable(value = "id") Integer id,
                                                      @Validated @RequestBody CategoryDTO categoryDTO)
            throws ResourceNotFoundException {
        CategoryDTO categoryUpdate = categoryService.findById(id);
        if (categoryUpdate.toString().length() == 0) {
            throw new ResourceNotFoundException("Not found Category with: " + id);
        } else {
            categoryUpdate.setCode(categoryDTO.getCode());
            categoryUpdate.setName(categoryDTO.getName());
            categoryUpdate.setDescriptions(categoryDTO.getDescriptions());
            categoryUpdate.setCreatedNew(categoryDTO.getCreatedNew());
            categoryUpdate.setCreatedEdit(categoryDTO.getCreatedEdit());
            final CategoryDTO updateCategory = categoryService.addCategory(categoryUpdate);
            return ResponseEntity.ok().body(updateCategory);
        }
    }

    @PostMapping(value = "/categories")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDTO categoryNew = categoryService.addCategory(categoryDTO);
        return categoryNew;
    }

    @DeleteMapping(value = "/categories/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        categoryService.deleteById(id);
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<List<CategoryDTO>> findByName(@RequestParam(defaultValue = "", required = false) String name) {
        List<CategoryDTO> categoryDTOList = categoryService.findByName(name);
        return ResponseEntity.ok().body(categoryDTOList);
    }

}
