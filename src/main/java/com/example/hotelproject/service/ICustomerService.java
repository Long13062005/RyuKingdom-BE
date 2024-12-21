package com.example.hotelproject.service;


import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findCustomersByName(String name, Pageable pageable);

    List<Customer> findAll();

    Customer findById(int id);

    Customer save(Customer customer);

    void deleteById(Long id);

    Customer findByName(String name);

    Customer findCustomerByUser_Username(String username);

}
