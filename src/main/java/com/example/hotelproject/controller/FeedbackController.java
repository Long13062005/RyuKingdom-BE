package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.controller.dto.response.PaymentDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.entities.Feedback;
import com.example.hotelproject.service.impl.CustomerService;
import com.example.hotelproject.service.impl.FeedbackService;
import com.example.hotelproject.service.impl.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    @GetMapping()
    public ResponseEntity<?> showAllFeedback(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "4") int size
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            Page<Feedback> feedbacks = feedbackService.findFeedbacksByNameContainingIgnoreCase( pageable);

            if (feedbacks.isEmpty()) {
                return new ResponseEntity<>("No Facility found", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(feedbacks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while fetching facilities", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/all")
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
