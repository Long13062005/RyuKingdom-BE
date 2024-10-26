package com.example.hotelproject.controller;

import com.example.hotelproject.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;


}
