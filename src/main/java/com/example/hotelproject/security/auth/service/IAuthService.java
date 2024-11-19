package com.example.hotelproject.security.auth.service;


import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.security.auth.request.AuthReq;
import com.example.hotelproject.security.auth.request.RegisterReq;

public interface IAuthService {

    MessengerRes register(RegisterReq registrationRequest);

    MessengerRes login(AuthReq loginRequest);

    MessengerRes refreshToken(AuthReq refreshTokenReqiest);


    MessengerRes logout(AuthReq logoutRequest);
}
