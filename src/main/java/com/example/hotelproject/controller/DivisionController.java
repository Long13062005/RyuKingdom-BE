package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.DivisionService;
import com.example.hotelproject.service.impl.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/division")
@CrossOrigin
public class DivisionController {
    @Autowired
    private DivisionService divisionService;
    
    @GetMapping()
    public ResponseEntity<?> showAllPositions() {
        try {
            return new ResponseEntity<>(divisionService.getAllDivisions(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching divisions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
