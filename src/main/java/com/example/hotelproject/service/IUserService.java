package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.controller.dto.response.UserReq;
import com.example.hotelproject.security.auth.request.ChangePasswordRequest;
import com.example.hotelproject.security.auth.request.RegisterReq;

public interface IUserService {
    void deleteUser(Long id);
    MessengerRes updateUserInfo(String username, UserReq updatedUser);
     MessengerRes getMyInfo(String username);

     MessengerRes updatePassword(String username, ChangePasswordRequest updatePasswords);

}
