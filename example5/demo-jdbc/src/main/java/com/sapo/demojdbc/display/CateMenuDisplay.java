package com.sapo.demojdbc.display;

import com.sapo.demojdbc.DemoJdbcApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.sapo.demojdbc.DemoJdbcApplication.err;

@Component
public class CateMenuDisplay {
    private final CategoryDisplay categoryDisplay;
    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);
    Scanner sc = new Scanner(System.in);

    public CateMenuDisplay(CategoryDisplay categoryDisplay) {
        this.categoryDisplay = categoryDisplay;
    }

    public void menuCategory(int choise2) {
        do {
            logger.info("****************Menu****************");
            logger.info("1. Show category");
            logger.info("2. Create new category");
            logger.info("3. Delete category");
            logger.info("4. Update category");
            logger.info("5. Find category by id");
            logger.info("6. Exit");
            logger.info("Your choise: ");
            do {
                try {
                    choise2 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    logger.info(err);
                }

            } while (true);
            switch (choise2) {
                case 1:
                    categoryDisplay.showCategories();
                    break;
                case 2:
                    categoryDisplay.insertCategory();
                    break;
                case 3:
                    categoryDisplay.deleteCategories();
                    break;
                case 4:
                    categoryDisplay.updateCategories();
                    break;
                case 5:
                    categoryDisplay.findCat();
                    break;
                case 6:
                    System.exit(0);
                default:
                    logger.info(err);
            }
        } while (choise2 != 6);

    }
}
