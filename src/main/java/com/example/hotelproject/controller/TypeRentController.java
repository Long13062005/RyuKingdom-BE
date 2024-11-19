package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.TypeRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type-rents")
@CrossOrigin
public class TypeRentController {
    @Autowired
    private TypeRentService typeRentService;

    @GetMapping()
    public ResponseEntity<?> showAllTypeRent() {
        try {
            return new ResponseEntity<>(typeRentService.getAllTypeRents(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
