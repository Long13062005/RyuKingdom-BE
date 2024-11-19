package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.controller.dto.response.PaymentDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Payment;
import com.example.hotelproject.service.impl.CustomerService;
import com.example.hotelproject.service.impl.FacilityService;
import com.example.hotelproject.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> showAllPayments() {
        try {
            return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Payments", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Payments", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(@RequestBody PaymentDto paymentDto) {
        try {

            return new ResponseEntity<>(paymentService.savePayment(paymentDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePayment(@RequestBody PaymentDto paymentDto   , @PathVariable Long id) {
        try {

            return new ResponseEntity<>(paymentService.updatePayment(id,paymentDto ), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePayment(@PathVariable Long id) {
        try {
            paymentService.deletePayment(id);
            return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting Payment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/customer")
    public ResponseEntity<?> getPayment() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            Customer customer = customerService.findCustomerByUser_Username(username);
            return new ResponseEntity<>(paymentService.findPaymentByCustomer(customer), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Payments", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
