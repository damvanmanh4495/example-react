package com.sapo.demojdbc.display;

import com.sapo.demojdbc.entities.Category;
import com.sapo.demojdbc.entities.Inventory;
import com.sapo.demojdbc.entities.Product;
import com.sapo.demojdbc.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDisplay {
    private final ProductService productService;

    public ProductDisplay(ProductService productService) {
        this.productService = productService;
    }

    public void showProducts() {
        List<Product> listPro = new ArrayList<>();
        listPro = productService.getAll();
        showResultList(listPro);
    }

    public void insertProduct() {
        Product product = new Product();
        product.setCode("123");
        product.setName("tu lanh");
        Category category = new Category();
        category.setId(3);
        product.setCategory(category);
        Inventory inventory = new Inventory();
        inventory.setId(2);
        product.setInventory(inventory);
        productService.save(product);
    }

    public void getTopSale() {
        List<Product> listPro = new ArrayList<>();
        listPro = productService.getTopSale();
        showResultList(listPro);
    }

    public void delete() {
        productService.delete(5);
    }

    public void findById() {
        Product product = productService.findById(8);
        showResult(product);
    }

    public void merge() {
        Product product = new Product();
        product.setCode("1234");
        product.setName("Dieu hoa");
        Category category = new Category();
        category.setId(3);
        product.setCategory(category);
        Inventory inventory = new Inventory();
        inventory.setId(2);
        product.setInventory(inventory);
        product.setNumber(100);
        product.setNumberSale(80);
        product.setId(9);
        productService.merge(product);
    }

    public void showResultList(List<Product> listPro) {
        for (int i = 0; i < listPro.size(); i++) {
            System.out.println("id: " + listPro.get(i).getId() +
                    "\tproductId: " + listPro.get(i).getCode() +
                    "\tproductName: " + listPro.get(i).getName() +
                    "\tcatId: " + listPro.get(i).getCategory().getId() +
                    "\twareId: " + listPro.get(i).getInventory().getId() +
                    "\tSo luong san pham: " + listPro.get(i).getNumber() +
                    "\tSo luong ban: " + listPro.get(i).getNumberSale() +
                    "\tNgay tao: " + listPro.get(i).getCreatedNew() +
                    "\tNgay sua: " + listPro.get(i).getCreatedEdit()
            );
        }
    }

    public void showResult(Product product) {
        System.out.println("id: " + product.getId() +
                "\tproductId: " + product.getCode() +
                "\tproductName: " + product.getName() +
                "\tcatId: " + product.getCategory().getId() +
                "\twareId: " + product.getInventory().getId() +
                "\tSo luong san pham: " + product.getNumber() +
                "\tSo luong ban: " + product.getNumberSale() +
                "\tNgay tao: " + product.getCreatedNew() +
                "\tNgay sua: " + product.getCreatedEdit());
    }


}
