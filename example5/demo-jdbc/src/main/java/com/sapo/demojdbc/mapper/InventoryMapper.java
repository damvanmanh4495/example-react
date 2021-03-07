package com.sapo.demojdbc.mapper;

import com.sapo.demojdbc.entities.Inventory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventoryMapper implements RowMapper<Inventory> {
    @Override
    public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setId(rs.getInt("id"));
        inventory.setCode(rs.getString("code"));
        inventory.setName(rs.getString("name"));
        inventory.setAddress(rs.getString("address"));
        inventory.setCreatedNew(rs.getDate("created_new").toString());
        inventory.setCreatedEdit(rs.getDate("created_edit").toString());
        return inventory;
    }
}
