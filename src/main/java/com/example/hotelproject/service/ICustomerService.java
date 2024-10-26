package com.example.hotelproject.service;


import com.example.hotelproject.entities.Customer;

import java.util.List;

public interface ICustomerService {
    public <T> List<T> findAll(Class<T> classType);
    public <T> T findById(int id, Class<T> classType);
    public Customer save(Customer customer);
    public void deleteById(int id);
    <T> List<T> searchByCustomerName(String name,  Class<T> classType);

    <T> T findByEmail(String email);
}
