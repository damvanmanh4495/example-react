package com.example.springapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/test")
public class TestRestAPIs {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String userAccess() {
        return ">>> User Contents!";
    }

    @GetMapping("/pm")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
    public String projectManagementAccess() {
        return ">>> Board Management Project";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Contents";
    }

    @PostMapping("/verify")
    @PreAuthorize("hasRole('PM') or hasRole('ADMIN') or hasRole('USER')")
    public String postVerify() {
        return "Method post success";
    }
}
