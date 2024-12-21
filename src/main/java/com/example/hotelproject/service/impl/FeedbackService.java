package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Feedback;
import com.example.hotelproject.repository.CustomerRepository;
import com.example.hotelproject.repository.FeedbackRepository;
import com.example.hotelproject.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Feedback> findFeedbacksByNameContainingIgnoreCase(Pageable pageable) {
        return feedbackRepository.findFeedbacksByNameContainingIgnoreCase(pageable);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.getAll();
    }

    @Override
    public Feedback getFeedbackById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    public Feedback getFeedbackByName(String name) {
        return null;
    }

    @Override
    public Feedback addFeedback(FeedbackDto feedbackDto) {
        Feedback feedback = new Feedback();
        Customer customer = customerRepository.findByUser_Username(feedbackDto.getCustomerName());
        feedback.setDescription(feedbackDto.getDescription());
        feedback.setRating(feedbackDto.getRating());
        feedback.setCustomer(customer);
        feedback.setDeleted(false);

        return  feedbackRepository.save(feedback);

    }

    @Override
    public void softDeleteFeedbackById(Long id) {
        feedbackRepository.softDeleteFeedbackById(id);
    }
}
