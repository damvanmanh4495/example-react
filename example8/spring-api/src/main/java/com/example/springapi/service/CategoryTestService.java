package com.example.springapi.service;

import com.example.springapi.entity.Category;
import com.example.springapi.repository.generic.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryTestService implements CategoryDAOtestService {
    private IGenericDao dao;

    @Autowired
    public void setDao(IGenericDao dao) {
        this.dao = dao;
        dao.setClazz(Category.class);
    }

    @Override
    public List<Category> getAll() {
        return dao.findAll();
    }
}
