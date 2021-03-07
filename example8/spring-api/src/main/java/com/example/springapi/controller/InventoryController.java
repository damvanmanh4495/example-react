package com.example.springapi.controller;

import com.example.springapi.converter.InventoryConvert;
import com.example.springapi.dto.InventoryDTO;
import com.example.springapi.exception.ResourceNotFoundException;
import com.example.springapi.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin/inventories")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryConvert inventoryConverter;

    @GetMapping(value = "")
    public ResponseEntity<List<InventoryDTO>> findByName(@RequestParam(defaultValue = "", required = false) String name) {
        List<InventoryDTO> inventoryDTOList = inventoryService.findByName(name);
        return ResponseEntity.ok().body(inventoryDTOList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<InventoryDTO> getInventoryId(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        InventoryDTO inventoryDTO = inventoryService.findById(id);
        if (inventoryDTO == null) {
            throw new ResourceNotFoundException("Not found Inventory with :" + id);
        } else {
            return ResponseEntity.ok().body(inventoryDTO);
        }
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public ResponseEntity<InventoryDTO> updateInventory(@PathVariable(value = "id") Integer id,
                                                        @Validated @RequestBody InventoryDTO inventoryDTO)
            throws ResourceNotFoundException {
        InventoryDTO inventoryUpdate = inventoryService.findById(id);
        if (inventoryDTO == null) {
            throw new ResourceNotFoundException("Not found Inventory with :" + id);
        } else {
            inventoryUpdate.setCode(inventoryDTO.getCode());
            inventoryUpdate.setName(inventoryDTO.getName());
            inventoryUpdate.setAddress(inventoryDTO.getAddress());
            inventoryUpdate.setCreated(inventoryDTO.getCreated());
            inventoryUpdate.setModified(inventoryDTO.getModified());
            final InventoryDTO updateInventory = inventoryService.addInventory(inventoryUpdate);
            return ResponseEntity.ok().body(updateInventory);
        }
    }

    @PostMapping(value = "/")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public InventoryDTO createInventory(@RequestBody InventoryDTO inventoryDTO) {
        return inventoryService.addInventory(inventoryDTO);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Boolean> deleteInventory(@PathVariable(value = "id") Integer id)
            throws ResourceNotFoundException {
        InventoryDTO inventoryDelete = inventoryService.findById(id);
        if (inventoryDelete == null) {
            throw new ResourceNotFoundException("Not found Inventory with :" + id);
        } else {
            inventoryService.deleteById(inventoryDelete.getId());
            Map<String, Boolean> result = new HashMap<>();
            result.put("delete success", Boolean.TRUE);
            return result;
        }
    }
}
