package com.example.hotelproject.service;

public interface ITypeCustomerService {
    void deleteTypeCustomer(Long id);
    void updateTypeCustomer(Long id, String name);
    void addTypeCustomer(String name);
    void getAllTypeCustomers();
    void getTypeCustomerById(Long id);
    void getTypeCustomerByName(String name);
}
