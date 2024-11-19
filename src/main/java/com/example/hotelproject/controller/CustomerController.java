package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> showAllCustomer() {
        try {
            return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Customer", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        try {
            customerService.deleteById(id);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting Employees", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
