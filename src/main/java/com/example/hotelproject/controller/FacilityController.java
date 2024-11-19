package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.service.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/facilities")
@CrossOrigin
public class FacilityController {
    @Autowired
    private FacilityService facilityService;


    @GetMapping()
    public ResponseEntity<?> showAllFacilities() {
        try {
            return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFacility(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(facilityService.findById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFacility(@RequestBody FacilityDto facilityDto) {
        try {

            return new ResponseEntity<>(facilityService.save(facilityDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating facility", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateFacility(@RequestBody FacilityDto facilityDto    , @PathVariable Long id) {
        try {

            return new ResponseEntity<>(facilityService.update(facilityDto,id ), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating facility", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFacility(@PathVariable Long id) {
        try {
            facilityService.delete(id);
            return new ResponseEntity<>("Facility deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting facility", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
