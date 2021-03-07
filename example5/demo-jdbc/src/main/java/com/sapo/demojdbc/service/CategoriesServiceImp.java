package com.sapo.demojdbc.service;

import com.sapo.demojdbc.dao.CategoriesDAO;
import com.sapo.demojdbc.entities.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesDAO categoriesDAO;

    public CategoriesServiceImp(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    @Override
    public List<Category> getAll() {
        return categoriesDAO.getAll();
    }

    @Override
    public boolean save(Category cat) {
        return categoriesDAO.save(cat);
    }

    @Override
    public boolean merge(Category cat) {
        return categoriesDAO.merge(cat);
    }

    @Override
    public boolean delete(int id) {
        return categoriesDAO.delete(id);
    }

    @Override
    public Category findByID(int id) {
        return categoriesDAO.findByID(id);
    }
}
