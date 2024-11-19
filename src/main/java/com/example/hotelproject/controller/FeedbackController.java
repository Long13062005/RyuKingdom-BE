package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.controller.dto.response.PaymentDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.service.impl.CustomerService;
import com.example.hotelproject.service.impl.FeedbackService;
import com.example.hotelproject.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/feedbacks")
@CrossOrigin
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private CustomerService customerService;


    @GetMapping()
    public ResponseEntity<?> showAllFeedback() {
        try {
            return new ResponseEntity<>(feedbackService.getAllFeedbacks(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Payments", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getFeedback(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(feedbackService.getFeedbackById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createFeedback(@RequestBody FeedbackDto feedbackDto) {
        try {

            return new ResponseEntity<>(feedbackService.addFeedback(feedbackDto), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFeedback(@PathVariable Long id) {
        try {
            feedbackService.softDeleteFeedbackById(id);
            return new ResponseEntity<>("Feedback deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while deleting Feedback", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
