package com.example.demosplinjection.service;

import com.example.demosplinjection.dto.UserDTO;
import com.example.demosplinjection.entity.User;
import com.example.demosplinjection.mapper.UserConverter;
import com.example.demosplinjection.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserConverter userConverter;
    @Override
    public UserDTO getByName(String name) {
        return userConverter.entityToDto(userRepository.findByName(name));
    }

    @Override
    public List<UserDTO> getAll() {
        return userConverter.entityToDto(userRepository.getAll());
    }
}
