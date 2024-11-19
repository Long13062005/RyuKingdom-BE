package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.PaymentDto;
import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Payment;
import com.example.hotelproject.repository.CustomerRepository;
import com.example.hotelproject.repository.EmployeeRepository;
import com.example.hotelproject.repository.PaymentRepository;
import com.example.hotelproject.service.IPaymentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {
@Autowired
    private PaymentRepository paymentRepository;
@Autowired
    private CustomerRepository customerRepository;
@Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAll();
    }

    @Override
    public PaymentDto getPaymentById(Long id) {
        PaymentDto paymentDto = new PaymentDto();
        Payment payment = paymentRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(payment, paymentDto);
        paymentDto.setEmployeeName(payment.getEmployee().getName());
        paymentDto.setCustomerName(payment.getCustomer().getName());
        return paymentDto;
    }

    @Override
    public Payment savePayment(PaymentDto paymentDto) {
        Payment payment = new Payment();
        Employee employee = employeeRepository.findByUser_Username(paymentDto.getEmployeeName());
        payment.setHistoryDate(paymentDto.getHistoryDate());
        payment.setDeposit(paymentDto.getDeposit());
        payment.setStatus(paymentDto.getStatus());
        payment.setTitle(paymentDto.getTitle());
        payment.setEmployee(employee);
        payment.setCustomer(customerRepository.findByName(paymentDto.getCustomerName()));
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.softDeletePaymentById(id);
    }

    @Override
    public Payment updatePayment(Long id, PaymentDto paymentDto) {
        Payment payment = paymentRepository.findById(id).orElse(null);
        payment.setCustomer(customerRepository.findByName(paymentDto.getCustomerName()));
        payment.setEmployee(employeeRepository.findByUser_Username(paymentDto.getEmployeeName()));
        payment.setDeposit(paymentDto.getDeposit());
        payment.setHistoryDate(paymentDto.getHistoryDate());
        payment.setStatus(paymentDto.getStatus());
        payment.setTitle(paymentDto.getTitle());
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> findPaymentByCustomer(Customer customer) {
        return paymentRepository.findByCustomer(customer.getId());
    }
}
