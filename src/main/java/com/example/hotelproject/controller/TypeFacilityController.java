package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.TypeFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type-facilities")
@CrossOrigin
public class TypeFacilityController {
    @Autowired
    private TypeFacilityService typeFacilityService;
    
    @GetMapping()
    public ResponseEntity<?> showAllTypeFacility() {
        try {
            return new ResponseEntity<>(typeFacilityService.getAllTypeFacilities(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
