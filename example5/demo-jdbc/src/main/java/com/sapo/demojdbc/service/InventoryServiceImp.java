package com.sapo.demojdbc.service;

import com.sapo.demojdbc.dao.InventoryDAO;
import com.sapo.demojdbc.entities.Inventory;
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

    @Override
    public boolean save(Inventory inventory) {
        return inventoryDAO.save(inventory);
    }

    @Override
    public boolean delete(int id) {
        return inventoryDAO.delete(id);
    }

    @Override
    public boolean merge(Inventory inventory) {
        return inventoryDAO.merge(inventory);
    }

    @Override
    public Inventory findById(int id) {
        return inventoryDAO.findById(id);
    }
}
