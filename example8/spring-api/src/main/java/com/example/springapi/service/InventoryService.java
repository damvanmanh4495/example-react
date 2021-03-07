package com.example.springapi.service;

import com.example.springapi.dto.InventoryDTO;
import com.example.springapi.entity.Inventory;

import java.util.List;

public interface InventoryService {
    List<InventoryDTO> findByName(String name);

    InventoryDTO findById(int id);

    void deleteById(int id);

    InventoryDTO addInventory(InventoryDTO inventoryDTO);

    void updateInventory(InventoryDTO inventoryDTO);

    List<Inventory> findAll();
}
