package com.sapo.demojdbc.service;

import com.sapo.demojdbc.dao.ProductDAO;
import com.sapo.demojdbc.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImp(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getTopSale() {
        return productDAO.getTopSale();
    }

    @Override
    public boolean delete(int id) {
        return productDAO.delete(id);
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean merge(Product product) {
        return productDAO.merge(product);
    }

}
