package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.repository.CustomerRepository;
import com.example.hotelproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
@Autowired
private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findCustomersByName(String name, Pageable pageable) {
        return customerRepository.findCustomersByNameContainingIgnoreCase(name, pageable);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.softDeleteCustomerById( id);
    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer findCustomerByUser_Username(String username) {
        return customerRepository.findByUser_Username(username);
    }
}
