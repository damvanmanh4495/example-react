package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Product;
import com.sapo.demojdbc.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class ProductDAOImp implements ProductDAO {
    private final JdbcTemplate jdbcTemplate;
    private final DataSource dataSource;
    final String getAll_query = "Select * from products";
    final String update_query = "update products set code = ?, name = ?, category_id = ?, inventory_id = ?, descriptions = ?, number = ?, number_sale = ? where id = ?";
    final String delete_query = "delete from products where id = ?";
    final String find_query = "Select * from products where id = ?";


    public ProductDAOImp(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(getAll_query, new ProductMapper());
    }

    @Override
    public boolean save(Product product) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("products");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("code", product.getCode());
        parameters.put("name", product.getName());
        parameters.put("category_id", product.getCategory().getId());
        parameters.put("inventory_id", product.getInventory().getId());
        parameters.put("number", product.getNumber());
        parameters.put("number_sale", product.getNumberSale());
        parameters.put("descriptions", product.getDescriptions());
        int check = jdbcInsert.execute(parameters);
        if (check == 1) {
            System.out.println("Success");
            return true;
        } else {
            System.out.println("Fail");
            return false;
        }
    }

    @Override
    public boolean merge(Product product) {
        boolean check = false;
        try {
            jdbcTemplate.update(update_query, product.getCode(), product.getName(), product.getCategory().getId(),
                    product.getInventory().getId(), product.getDescriptions(), product.getNumber(), product.getNumberSale(), product.getId());
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean delete(int id) {
        boolean check = false;
        try {
            jdbcTemplate.update(delete_query, id);
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public Product findById(int id) {
        return jdbcTemplate.queryForObject(find_query, new ProductMapper(), id);
    }

    @Override
    public List<Product> getTopSale() {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource).withProcedureName("get_top10_sale")
                .returningResultSet("products", new ProductMapper());

        Map<String, Object> out = simpleJdbcCall.execute();
        List<Product> listPro = (List<Product>) out.get("products");
        return listPro;
    }


}
