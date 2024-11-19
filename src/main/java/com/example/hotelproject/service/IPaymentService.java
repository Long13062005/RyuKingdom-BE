package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.PaymentDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Payment;

import java.util.List;

public interface IPaymentService {

    List<Payment> getAllPayments();

    PaymentDto getPaymentById(Long id);

    Payment savePayment(PaymentDto paymentDto);

    void deletePayment(Long id);

    Payment updatePayment(Long id, PaymentDto paymentDto);

    List<Payment> findPaymentByCustomer(Customer customer);

}
