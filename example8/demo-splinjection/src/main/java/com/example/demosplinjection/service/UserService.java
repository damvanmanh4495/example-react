package com.example.demosplinjection.service;

import com.example.demosplinjection.dto.UserDTO;
import com.example.demosplinjection.entity.User;

import java.util.List;

public interface UserService {
    UserDTO getByName(String name);
    List<UserDTO>  getAll();
}
