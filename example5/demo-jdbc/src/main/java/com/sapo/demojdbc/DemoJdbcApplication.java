package com.sapo.demojdbc;

import com.sapo.demojdbc.display.CateMenuDisplay;
import com.sapo.demojdbc.display.InvMenuDisplay;
import com.sapo.demojdbc.display.ProMenuDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoJdbcApplication implements CommandLineRunner {
    private final InvMenuDisplay menuInventory;
    private final CateMenuDisplay cateMenuDisplay;
    private final ProMenuDisplay proMenuDisplay;
    Scanner sc = new Scanner(System.in);
    public static String err = "Please re-enter your choise: ";
    int choise = 0;
    int choise1 = 0;
    int choise2 = 0;
    int choise3 = 0;

    public DemoJdbcApplication(CateMenuDisplay cateMenuDisplay, InvMenuDisplay menuInventory, ProMenuDisplay proMenuDisplay) {
        this.cateMenuDisplay = cateMenuDisplay;
        this.menuInventory = menuInventory;
        this.proMenuDisplay = proMenuDisplay;
    }

    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoJdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        do {
            logger.info("");
            logger.info("*************MENU*************");
            logger.info("1. Inventory management");
            logger.info("2. Category management");
            logger.info("3. Product management");
            logger.info("4. Exit");
            logger.info("Your choise: \t");
            do {
                try {
                    choise = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    logger.info(err);
                }
            } while (true);

            switch (choise) {
                case 1:
                    menuInventory.menuInventory(choise1);
                    break;
                case 2:
                    cateMenuDisplay.menuCategory(choise2);
                    break;
                case 3:
                    proMenuDisplay.menuProduct(choise3);
                    break;
                case 4:
                    System.exit(0);
                default:
                    logger.info(err);
                    break;
            }
        } while (choise != 4);
    }

}
