package com.sapo.springbootjpa;

import com.sapo.springbootjpa.entities.Inventory;
import com.sapo.springbootjpa.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {
    private final InventoryService inventoryService;

    public SpringBootJpaApplication(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
      showWareHouse();

    }

    public void showWareHouse(){
        List<Inventory> inventoryList = new ArrayList<>();
        inventoryList = inventoryService.getAll();
        for (int i = 0; i < inventoryList.size(); i++){
            System.out.println("id: " + inventoryList.get(i).getId() +
                    "\twareId: " + inventoryList.get(i).getCode() +
                    "\twareName: " + inventoryList.get(i).getName() +
                    "\twareAddress: " + inventoryList.get(i).getAddress() +
                    "\tNgay tao: " + inventoryList.get(i).getCreatedNew() +
                    "\tNgay sua: " + inventoryList.get(i).getCreatedEdit()
            );
        }
    }
}
