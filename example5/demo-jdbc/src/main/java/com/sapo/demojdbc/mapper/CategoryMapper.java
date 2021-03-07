package com.sapo.demojdbc.mapper;

import com.sapo.demojdbc.entities.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setCode(rs.getString("code"));
        category.setName(rs.getString("name"));
        category.setDescription(rs.getString("descriptions"));
        category.setCreatedNew(rs.getDate("created_new").toString());
        category.setCreatedEdit(rs.getDate("created_edit").toString());
        return category;
    }
}
