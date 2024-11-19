package com.example.hotelproject.service;


import com.example.hotelproject.entities.Customer;

import java.util.List;

public interface ICustomerService {
List<Customer> findAll();
Customer findById(int id);
Customer save(Customer customer);
void deleteById(Long id);

Customer findByName(String name);

Customer findCustomerByUser_Username(String username);

}
