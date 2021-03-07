package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();

    boolean save(Product product);

    boolean merge(Product product);

    boolean delete(int id);

    Product findById(int id);

    List<Product> getTopSale();


}
