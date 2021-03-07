package com.sapo.demojdbc.display;

import com.sapo.demojdbc.DemoJdbcApplication;
import com.sapo.demojdbc.entities.Inventory;
import com.sapo.demojdbc.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryDisplay {
    private final InventoryService inventoryService;
    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);

    public InventoryDisplay(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void showWareHouse() {
        List<Inventory> listWH = new ArrayList<>();
        listWH = inventoryService.getAll();
        showResultList(listWH);
    }

    public void insertInventory() {
        Inventory inventory = new Inventory();
        inventory.setCode("5");
        inventory.setName("Kho 6");
        inventory.setAddress("mo ta kho 6");
        inventoryService.save(inventory);
    }

    public void deleteInventory() {
        inventoryService.delete(2);
    }

    public void updateInventory() {
        Inventory inventory = new Inventory();
        inventory.setCode("9");
        inventory.setName("Kho 9");
        inventory.setAddress("mo ta kho 9");
        inventory.setId(3);
        inventoryService.merge(inventory);
    }

    public void findById() {
        Inventory inventory = inventoryService.findById(1);
        showResult(inventory);
    }

    public void showResultList(List<Inventory> listWH) {
        for (int i = 0; i < listWH.size(); i++) {
            logger.info("id: " + listWH.get(i).getId() +
                    "\twareId: " + listWH.get(i).getCode() +
                    "\twareName: " + listWH.get(i).getName() +
                    "\twareAddress: " + listWH.get(i).getAddress() +
                    "\tNgay tao: " + listWH.get(i).getCreatedNew() +
                    "\tNgay sua: " + listWH.get(i).getCreatedEdit()
            );
        }
    }

    public void showResult(Inventory inventory) {
        logger.info("id: " + inventory.getId() +
                "\twareId: " + inventory.getCode() +
                "\twareName: " + inventory.getName() +
                "\twareAddress: " + inventory.getAddress() +
                "\tNgay tao: " + inventory.getCreatedNew() +
                "\tNgay sua: " + inventory.getCreatedEdit()
        );

    }
}
