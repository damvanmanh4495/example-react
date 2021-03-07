package com.sapo.demojdbc.service;

import com.sapo.demojdbc.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    boolean save(Product product);

    List<Product> getTopSale();

    boolean delete(int id);

    Product findById(int id);

    boolean merge(Product product);

}
