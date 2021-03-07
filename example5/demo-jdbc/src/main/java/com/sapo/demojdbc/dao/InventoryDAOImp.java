package com.sapo.demojdbc.dao;

import com.sapo.demojdbc.entities.Inventory;
import com.sapo.demojdbc.mapper.InventoryMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAOImp implements InventoryDAO {
    private final JdbcTemplate jdbcTemplate;
    final String getAll_query = "Select * from inventory";
    final String insert_query = "insert into inventory(code, name, address) values(?,?,?)";
    final String update_query = "update inventory set code = ?, name = ?, address = ? where id = ?";
    final String delete_query = "delete from inventory where id = ?";
    final String find_query = "Select * from inventory where id = ?";

    public InventoryDAOImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Inventory> getAll() {
        return jdbcTemplate.query(getAll_query, new InventoryMapper());
    }

    @Override
    public boolean save(Inventory inventory) {
        boolean check = false;
        try {
            jdbcTemplate.update(insert_query, inventory.getCode(), inventory.getName(), inventory.getAddress());
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    @Override
    public boolean merge(Inventory inventory) {
        boolean check = false;
        try {
            jdbcTemplate.update(update_query, inventory.getCode(), inventory.getName(), inventory.getAddress(), inventory.getId());
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
    public Inventory findById(int id) {
        return jdbcTemplate.queryForObject(find_query, new InventoryMapper(), id);
    }
}
