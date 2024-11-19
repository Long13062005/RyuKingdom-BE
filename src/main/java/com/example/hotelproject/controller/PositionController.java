package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.DegreeService;
import com.example.hotelproject.service.impl.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/position")
@CrossOrigin
public class PositionController {
    @Autowired
    private PositionService positionService;
    
    @GetMapping()
    public ResponseEntity<?> showAllPositions() {
        try {
            return new ResponseEntity<>(positionService.getAllPositions(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching positions", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
