package com.example.springapi.service.Impl;

import com.example.springapi.converter.InventoryConvert;
import com.example.springapi.dto.InventoryDTO;
import com.example.springapi.entity.Inventory;
import com.example.springapi.repository.InventoryRepository;
import com.example.springapi.repository.generic.IGenericDao;
import com.example.springapi.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InventoryServiceImp implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryConvert inventoryConverter;
    IGenericDao<Inventory> dao;

    @Autowired
    public void setDao(IGenericDao<Inventory> daoToSet) {
        dao = daoToSet;
        dao.setClazz(Inventory.class);
    }

    @Override
    public List<InventoryDTO> findByName(String name) {
        List<InventoryDTO> inventoryDTOList = new ArrayList<>();
        List<Inventory> inventories = inventoryRepository.findAll();
        for (Inventory inventory : inventories) {
            if (inventory.getName().contains(name)) {
                InventoryDTO inventoryDTO = inventoryConverter.entityToDto(inventory);
                inventoryDTOList.add(inventoryDTO);
            }
        }
        return inventoryDTOList;
    }

    @Override
    public InventoryDTO findById(int id) {
        Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
        Inventory inventory = inventoryOptional.get();
        return inventoryConverter.entityToDto(inventory);
    }

    @Override
    public void deleteById(int id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public InventoryDTO addInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = inventoryConverter.dtoToEntity(inventoryDTO);
        inventoryRepository.save(inventory);
        return inventoryDTO;
    }

    @Override
    public void updateInventory(InventoryDTO inventoryDTO) {

    }

    @Override
    public List<Inventory> findAll() {
        return dao.findAll();
    }
}
