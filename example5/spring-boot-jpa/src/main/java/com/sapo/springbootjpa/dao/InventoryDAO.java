package com.sapo.springbootjpa.dao;

import com.sapo.springbootjpa.entities.Inventory;


import java.util.List;

public interface InventoryDAO {
    public List<Inventory> getAll();
}
