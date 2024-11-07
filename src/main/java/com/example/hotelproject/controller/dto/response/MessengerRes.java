package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Customer;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Role;
import com.example.hotelproject.entities.TypeCustomer;
import com.example.hotelproject.security.user_auth.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessengerRes {
    private int statusCode;
    private String error;
    private String message;
    private String token;
    private String refreshToken;
    private String expirationTime;
    private Customer customer;
    private User user;
    private Employee employee;
    private Role roles;
    private String name;
    private String dob;
    private String idCard;
    private Long gender;
    private String phoneNumber;
    private String email;
    private String address;
    private TypeCustomer typeCustomer;
    private UserReq userReq;

}
