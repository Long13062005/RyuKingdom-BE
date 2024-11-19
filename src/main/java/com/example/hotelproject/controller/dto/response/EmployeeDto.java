package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.Degree;
import com.example.hotelproject.entities.Division;
import com.example.hotelproject.entities.Position;
import com.example.hotelproject.security.user_auth.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private Long id;
    private String username;
    private String role;
    private String password;
    private String division;
    private String degree;
    private String position;
    private String name;
    private String dob;
    private String idCard;
    private Double salary;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;
    private boolean deleted = false;
}
