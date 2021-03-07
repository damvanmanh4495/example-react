package com.sapo.demojdbc.service;

import com.sapo.demojdbc.entities.Inventory;

import java.util.List;

public interface InventoryService {
    List<Inventory> getAll();

    boolean save(Inventory inventory);

    boolean delete(int id);

    boolean merge(Inventory inventory);

    Inventory findById(int id);
}
