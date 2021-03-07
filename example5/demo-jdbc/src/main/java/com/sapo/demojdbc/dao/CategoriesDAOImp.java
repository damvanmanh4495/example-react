package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Category;
import com.sapo.demojdbc.mapper.CategoryMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesDAOImp implements CategoriesDAO {
    private final JdbcTemplate jdbcTemplate;
    final String getAll_query = "Select * from categories";
    final String insert_query = "insert into categories(code, name, descriptions) values(?,?,?)";
    final String update_query = "update categories set code = ?, name = ?, descriptions = ? where id = ?";
    final String delete_query = "delete from categories where id = ?";
    final String find_query = "Select * from categories where id = ?";

    public CategoriesDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Category> getAll() {
        return jdbcTemplate.query(getAll_query, new CategoryMapper());
    }

    @Override
    public boolean save(Category cat) {
        boolean check = false;
        try {
            jdbcTemplate.update(insert_query, cat.getCode(), cat.getName(), cat.getDescription());
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean merge(Category cat) {
        boolean check = false;
        try {
            jdbcTemplate.update(update_query, cat.getCode(), cat.getName(), cat.getDescription(), cat.getId());
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
    public Category findByID(int id) {
        return jdbcTemplate.queryForObject(find_query, new CategoryMapper(), id);
    }


}
