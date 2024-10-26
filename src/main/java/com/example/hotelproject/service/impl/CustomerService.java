package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Override
    public <T> List<T> findAll(Class<T> classType) {
        return null;
    }

    @Override
    public <T> T findById(int id, Class<T> classType) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public <T> List<T> searchByCustomerName(String name, Class<T> classType) {
        return null;
    }

    @Override
    public <T> T findByEmail(String email) {
        return null;
    }
}
