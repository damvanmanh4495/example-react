package com.example.demosplinjection.repository;

import com.example.demosplinjection.entity.User;

import java.util.List;

public interface UserRepository {
    User findByName(String name);
    List<User> getAll();
}
