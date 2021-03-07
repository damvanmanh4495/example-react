package com.example.demosplinjection.mapper;

import com.example.demosplinjection.dto.UserDTO;
import com.example.demosplinjection.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public UserDTO entityToDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> entityToDto(List<User> users) {
        return users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public User dtoToEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }
}
