package com.example.springapi.controller;

import com.example.springapi.dto.ProductDTO;
import com.example.springapi.exception.ResourceNotFoundException;
import com.example.springapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin")
public class ProductController {
    private final ProductService productService;


    @GetMapping(value = "/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        ProductDTO productDTO = productService.findById(id);
        if (productDTO == null) {
            throw new ResourceNotFoundException("Not found Product with id: " + id);
        } else {
            return ResponseEntity.ok().body(productDTO);
        }
    }

    @PutMapping(value = "/products/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable(value = "id") Integer id,
                                                    @Validated @RequestBody ProductDTO productDTO)
            throws ResourceNotFoundException {
        ProductDTO productUpdate = productService.findById(id);
        if (productUpdate == null) {
            throw new ResourceNotFoundException("Not found Product with id: " + id);
        } else {
            productUpdate.setCode(productDTO.getCode());
            productUpdate.setName(productDTO.getName());
            productUpdate.setCategoryId(productDTO.getCategoryId());
            productUpdate.setInventoryId(productDTO.getInventoryId());
            productUpdate.setNumber(productDTO.getNumber());
            productUpdate.setNumberSale(productDTO.getNumberSale());
            productUpdate.setCreatedNew(productDTO.getCreatedNew());
            productUpdate.setCreatedEdit(productDTO.getCreatedEdit());
            final ProductDTO updateProduct = productService.addProduct(productUpdate);
            return ResponseEntity.ok().body(updateProduct);
        }
    }

    @PostMapping(value = "/products")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @DeleteMapping(value = "/products/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        ProductDTO productDTO = productService.findById(id);
        if (productDTO == null) {
            throw new ResourceNotFoundException("Not found product with id: " + id);
        } else {
            productService.deleteById(id);
            Map<String, Boolean> response = new HashMap<>();
            response.put("deleted", Boolean.TRUE);
            return response;
        }
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(defaultValue = "0", required = false) int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "") String name) {
        List<ProductDTO> productDTOList = productService.findByName(page, size, name);
        return ResponseEntity.ok().body(productDTOList);
    }
}
