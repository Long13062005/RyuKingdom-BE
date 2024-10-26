package com.example.hotelproject.service;

public interface IPaymentService {
    void deletePayment(Long id);
    void updatePayment(Long id, String name);
    void addPayment(String name);
    void getAllPayments();
    void getPaymentById(Long id);
    void getPaymentByName(String name);
}
