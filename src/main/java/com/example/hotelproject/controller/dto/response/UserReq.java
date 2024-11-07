package com.example.hotelproject.controller.dto.response;

import com.example.hotelproject.entities.TypeCustomer;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReq {
    private String username;
    private String fullName;
    private String dob;
    private String idCard;
    private int gender;
    private String phoneNumber;
    private String email;
    private String address;
    private String typeCustomer;
    private String education;
    private String division;
    private String position;
    private String role;
}
