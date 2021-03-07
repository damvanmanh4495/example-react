package com.sapo.demojdbc.display;

import com.sapo.demojdbc.DemoJdbcApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.sapo.demojdbc.DemoJdbcApplication.err;


@Component
public class InvMenuDisplay {
    private final InventoryDisplay inventoryDisplay;
    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);
    Scanner sc = new Scanner(System.in);

    public InvMenuDisplay(InventoryDisplay inventoryDisplay) {
        this.inventoryDisplay = inventoryDisplay;
    }

    public void menuInventory(int choise1) {
        do {
            logger.info("****************Menu****************");
            logger.info("1. Show Inventory");
            logger.info("2. Create new inventory");
            logger.info("3. Delete inventory");
            logger.info("4. Update inventory");
            logger.info("5. Find inventory by id");
            logger.info("6. Exit");
            logger.info("Your choise: ");
            do {
                try {
                    choise1 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    logger.info(err);
                }
            } while (true);
            switch (choise1) {
                case 1:
                    inventoryDisplay.showWareHouse();
                    break;
                case 2:
                    inventoryDisplay.insertInventory();
                    break;
                case 3:
                    inventoryDisplay.deleteInventory();
                    break;
                case 4:
                    inventoryDisplay.updateInventory();
                    break;
                case 5:
                    inventoryDisplay.findById();
                    break;
                case 6:
                    System.exit(0);
                default:
                    logger.info(err);
            }

        } while (choise1 != 6);
    }
}
