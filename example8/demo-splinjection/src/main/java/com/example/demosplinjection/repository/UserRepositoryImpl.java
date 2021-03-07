package com.example.demosplinjection.repository;

import com.example.demosplinjection.entity.User;
import com.example.demosplinjection.util.ConnectionDB;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private EntityManager entityManager;
    @Override
    public User findByName(String name) {
        final  String query="SELECT * FROM  users where name= '"+name+"'";
        Connection connection = null;
        ResultSet rs = null;
        User user = null;

        try {
            connection = ConnectionDB.openConnection();
            Statement st = connection.createStatement();
            rs = st.executeQuery(query);
            user = new User();
            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, null);
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        final  String query="SELECT * FROM  users ";
        Connection connection = null;
        ResultSet rs = null;
        List<User> users = null;

        try {
            connection = ConnectionDB.openConnection();
            Statement st = connection.createStatement();
            rs = (ResultSet) entityManager.createQuery(query).getResultList();
            users = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, null);
        }
        return users;
    }
}
