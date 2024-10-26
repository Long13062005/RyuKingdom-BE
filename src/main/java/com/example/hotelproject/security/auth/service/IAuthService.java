package com.example.hotelproject.security.auth.service;


import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.security.auth.request.AuthReq;
import com.example.hotelproject.security.auth.request.RegisterReq;

public interface IAuthService {

    public MessengerRes register(RegisterReq registrationRequest);

    public MessengerRes login(AuthReq loginRequest);

    public MessengerRes refreshToken(AuthReq refreshTokenReqiest);


    public MessengerRes logout(AuthReq logoutRequest);
}
