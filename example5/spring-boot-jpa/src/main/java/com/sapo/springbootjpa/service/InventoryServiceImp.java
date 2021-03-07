package com.sapo.springbootjpa.service;

import com.sapo.springbootjpa.dao.InventoryDAO;
import com.sapo.springbootjpa.entities.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImp implements InventoryService {
    private final InventoryDAO inventoryDAO;

    public InventoryServiceImp(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public List<Inventory> getAll() {
        return inventoryDAO.getAll();
    }
}
