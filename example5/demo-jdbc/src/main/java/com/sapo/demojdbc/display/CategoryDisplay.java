package com.sapo.demojdbc.display;

import com.sapo.demojdbc.DemoJdbcApplication;
import com.sapo.demojdbc.entities.Category;
import com.sapo.demojdbc.service.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryDisplay {
    private final CategoriesService categoriesService;
    Logger logger = LoggerFactory.getLogger(DemoJdbcApplication.class);

    public CategoryDisplay(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    public void showCategories() {
        List<Category> listCat = new ArrayList<Category>();
        listCat = categoriesService.getAll();
        for (int i = 0; i < listCat.size(); i++) {
            logger.info("id: " + listCat.get(i).getId() +
                    "\tcatId: " + listCat.get(i).getCode() +
                    "\tcatName: " + listCat.get(i).getName() +
                    "\tNgay tao: " + listCat.get(i).getCreatedNew() +
                    "\tNgay sua: " + listCat.get(i).getCreatedEdit()
            );
        }
    }

    public void insertCategory() {
        Category category = new Category();
        category.setCode("4");
        category.setName("quan ao fake2");
        category.setDescription("mo ta quan ao");
        categoriesService.save(category);
    }

    public void findCat() {
        int id = 2;
        Category category = categoriesService.findByID(2);
        logger.info("id: " + category.getId() +
                "\tcatId: " + category.getCode() +
                "\tdescriptions: " + category.getDescription() +
                "\tcatName: " + category.getName() +
                "\tNgay tao: " + category.getCreatedNew() +
                "\tNgay sua: " + category.getCreatedEdit());
    }

    public void deleteCategories() {
        int id = 3;
        categoriesService.delete(id);
    }

    public void updateCategories() {
        Category category = new Category();
        category.setCode("4");
        category.setName("quan ao fake2");
        category.setDescription("mo ta quan ao");
        categoriesService.merge(category);
    }
}
