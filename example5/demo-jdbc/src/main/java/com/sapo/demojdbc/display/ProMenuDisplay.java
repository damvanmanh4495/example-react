package com.sapo.demojdbc.display;

import com.sapo.demojdbc.DemoJdbcApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.sapo.demojdbc.DemoJdbcApplication.err;

@Component
public class ProMenuDisplay {
    private final ProductDisplay productDisplay;
    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);
    Scanner sc = new Scanner(System.in);

    public ProMenuDisplay(ProductDisplay productDisplay) {
        this.productDisplay = productDisplay;
    }

    public void menuProduct(int choise3) {
        do {
            logger.info("****************Menu****************");
            logger.info("1. Show product");
            logger.info("2. Create new product");
            logger.info("3. Delete product");
            logger.info("4. Update product");
            logger.info("5. Find product by id");
            logger.info("6. Top 10 product sale");
            logger.info("7. Exit");
            logger.info("Your choise: ");
            do {
                try {
                    choise3 = Integer.parseInt(sc.nextLine());
                    break;
                } catch (Exception e) {
                    logger.info(err);
                }
            } while (true);
            switch (choise3) {
                case 1:
                    productDisplay.showProducts();
                    break;
                case 2:
                    productDisplay.insertProduct();
                    break;
                case 3:
                    productDisplay.delete();
                    break;
                case 4:
                    productDisplay.merge();
                    break;
                case 5:
                    productDisplay.findById();
                    break;
                case 6:
                    productDisplay.getTopSale();
                    break;
                case 7:
                    System.exit(0);
                default:
                    logger.info(err);
                    break;
            }
        } while (choise3 != 7);

    }
}
