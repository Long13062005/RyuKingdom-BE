package com.example.hotelproject.security.auth.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthReq {
    private String username;
    private String password;
    private String refreshToken;
}
