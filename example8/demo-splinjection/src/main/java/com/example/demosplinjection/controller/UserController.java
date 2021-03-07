package com.example.demosplinjection.controller;

import com.example.demosplinjection.dto.UserDTO;
import com.example.demosplinjection.entity.User;
import com.example.demosplinjection.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    @GetMapping(value = "/users/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable(value = "name") String name){
        UserDTO userDTO = userService.getByName(name);
        return ResponseEntity.ok().body(userDTO);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> userDTOList = userService.getAll();
        return ResponseEntity.ok().body(userDTOList);
    }
}
