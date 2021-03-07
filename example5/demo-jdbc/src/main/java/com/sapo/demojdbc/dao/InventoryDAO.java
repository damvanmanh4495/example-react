package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Inventory;

import java.util.List;

public interface InventoryDAO {
    List<Inventory> getAll();

    boolean save(Inventory inventory);

    boolean merge(Inventory inventory);

    boolean delete(int id);

    Inventory findById(int id);
}
