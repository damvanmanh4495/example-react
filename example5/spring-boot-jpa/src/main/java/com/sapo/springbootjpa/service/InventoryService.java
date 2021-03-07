package com.sapo.springbootjpa.service;

import com.sapo.springbootjpa.entities.Inventory;

import java.util.List;

public interface InventoryService {
    public List<Inventory> getAll();
}
