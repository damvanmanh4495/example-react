package com.example.springapi.controller;
import com.example.springapi.dto.CategoryDTO;
import com.example.springapi.exception.ResourceNotFoundException;
import com.example.springapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000", maxAge = 3600)
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
//    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable(value = "id") Integer id,
                                                      @Validated @RequestBody CategoryDTO categoryDTO)
            throws ResourceNotFoundException {
        CategoryDTO categoryUpdate = categoryService.findById(id);
        if (categoryUpdate == null) {
            throw new ResourceNotFoundException("Not found Category with: " + id);
        } else {
            categoryUpdate.setCode(categoryDTO.getCode());
            categoryUpdate.setName(categoryDTO.getName());
            categoryUpdate.setDescriptions(categoryDTO.getDescriptions());
            final CategoryDTO updateCategory = categoryService.addCategory(categoryUpdate);
            return ResponseEntity.ok().body(updateCategory);
        }
    }

    @PostMapping(value = "/categories")
    @ResponseStatus(HttpStatus.CREATED)
//    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.addCategory(categoryDTO);
    }

    @DeleteMapping(value = "/categories/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteCategory(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        categoryService.deleteById(id);
        return new ResponseEntity<>("delete success", HttpStatus.OK);
    }

    @GetMapping(value = "/categories")
//    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> findByName(@RequestParam(defaultValue = "1", required = false) int page,
                                                        @RequestParam(defaultValue = "5", required = false) int size,
                                                        @RequestParam(defaultValue = "", required = false ) String name) {
        List<CategoryDTO> categoryDTOList = categoryService.getAll(page, size, name);
        Map<String, Object> result = new HashMap<>();
        result.put("categories", categoryDTOList);
        result.put("total_page", categoryService.count());
        return ResponseEntity.ok().body(result);
    }

}
