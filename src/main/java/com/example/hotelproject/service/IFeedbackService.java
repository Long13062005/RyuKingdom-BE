package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.FeedbackDto;
import com.example.hotelproject.entities.Feedback;

import java.util.List;

public interface IFeedbackService {
List<Feedback> getAllFeedbacks();
Feedback getFeedbackById(Long id);
Feedback getFeedbackByName(String name);

     Feedback addFeedback(FeedbackDto feedbackDto) ;

void softDeleteFeedbackById(Long id);
}
