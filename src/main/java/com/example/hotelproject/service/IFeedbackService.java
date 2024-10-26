package com.example.hotelproject.service;

public interface IFeedbackService {
    void deleteFeedback(Long id);
    void updateFeedback(Long id, String name);
    void addFeedback(String name);
    void getAllFeedbacks();
    void getFeedbackById(Long id);
    void getFeedbackByName(String name);
}
