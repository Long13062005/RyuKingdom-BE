package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.entities.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFeedbackService {
    Page<Feedback> findFeedbacksByNameContainingIgnoreCase(Pageable pageable);

    List<Feedback> getAllFeedbacks();

    Feedback getFeedbackById(Long id);

    Feedback getFeedbackByName(String name);

    Feedback addFeedback(FeedbackDto feedbackDto);

    void softDeleteFeedbackById(Long id);
}
