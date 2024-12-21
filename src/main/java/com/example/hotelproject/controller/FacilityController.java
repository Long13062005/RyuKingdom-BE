package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.service.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<?> showAllFacilities(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "4") int size,
            @RequestParam(required = false, defaultValue = "") String name
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Facility> facility = facilityService.findFacilityByName(name, pageable);

            if (facility.isEmpty()) {
                return new ResponseEntity<>("No Facility found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(facility, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> showAllFacilities() {
        try {
            if (facilityService.findAll().isEmpty()) {
                return new ResponseEntity<>("No Facilities found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(facilityService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Facilities", HttpStatus.INTERNAL_SERVER_ERROR);
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
    @GetMapping("/search/{name}")
    public ResponseEntity<?> searchFacility(@PathVariable String name) {
        try {
            return new ResponseEntity<>(facilityService.searchFacilities(name), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
