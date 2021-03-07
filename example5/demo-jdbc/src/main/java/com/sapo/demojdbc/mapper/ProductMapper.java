package com.sapo.demojdbc.mapper;

import com.sapo.demojdbc.entities.Category;
import com.sapo.demojdbc.entities.Inventory;
import com.sapo.demojdbc.entities.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setCode(rs.getString("code"));
        product.setName(rs.getString("name"));
        product.setNumber(rs.getInt("number"));
        product.setNumberSale(rs.getInt("number_sale"));
        product.setCreatedNew(rs.getDate("created_new").toString());
        product.setCreatedEdit(rs.getDate("created_edit").toString());
        Category category = new Category(rs.getInt("id"));
        product.setCategory(category);
        Inventory inventory = new Inventory(rs.getInt("id"));
        product.setInventory(inventory);
        return product;
    }
}
