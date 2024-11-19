package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.DivisionService;
import com.example.hotelproject.service.impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/role")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    @GetMapping()
    public ResponseEntity<?> showAllRoles() {
        try {
            return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching roles", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
