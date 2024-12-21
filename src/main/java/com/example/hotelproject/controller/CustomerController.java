package com.example.hotelproject.controller;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public ResponseEntity<?> showAllCustomer( @RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false, defaultValue = "4") int size,
                                              @RequestParam(required = false, defaultValue = "") String name
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Customer> customers = customerService.findCustomersByName(name, pageable);

            if (customers.isEmpty()) {
                return new ResponseEntity<>("No Customer found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Customers", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
    public ResponseEntity<?> showAllCustomer() {
        try {
            if (customerService.findAll().isEmpty()) {
                return new ResponseEntity<>("No Customer found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Customers", HttpStatus.INTERNAL_SERVER_ERROR);
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
