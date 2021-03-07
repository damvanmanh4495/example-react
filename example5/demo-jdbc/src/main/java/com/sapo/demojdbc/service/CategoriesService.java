package com.sapo.demojdbc.service;

import com.sapo.demojdbc.entities.Category;

import java.util.List;

public interface CategoriesService {
    List<Category> getAll();

    boolean save(Category cat);

    boolean merge(Category cat);

    boolean delete(int id);

    Category findByID(int id);
}
