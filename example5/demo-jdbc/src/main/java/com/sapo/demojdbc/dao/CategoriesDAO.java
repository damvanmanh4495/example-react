package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Category;

import java.util.List;

public interface CategoriesDAO {
    List<Category> getAll();

    boolean save(Category cat);

    boolean merge(Category cat);

    boolean delete(int id);

    Category findByID(int id);
}
