package com.example.hotelproject.controller;

import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.controller.dto.response.UserReq;
import com.example.hotelproject.security.auth.request.ChangePasswordRequest;
import com.example.hotelproject.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/adminstaffcus/update")
    public ResponseEntity<MessengerRes> updateUserByStaff(@RequestBody UserReq reqres){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(userService.updateUserInfo(username, reqres));
    }

    @PutMapping("/adminstaffcus/avatar/update")
    public ResponseEntity<MessengerRes> updateAvatar(@RequestBody UserReq reqres){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(userService.changeAvatar(username, reqres.getImgUrl()));
    }

    @GetMapping("/adminstaffcus/avatar")
    public ResponseEntity<MessengerRes> getAvatar(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(userService.getAvatar(username));
    }


    @PutMapping("/adminstaffcus/update/password")
    public ResponseEntity<MessengerRes> updateUserPassword(@RequestBody ChangePasswordRequest reqres){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return ResponseEntity.ok(userService.updatePassword(username, reqres));
    }

    @GetMapping("/adminstaffcus/profile")
    public ResponseEntity<MessengerRes> getMyProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        MessengerRes response = userService.getMyInfo(username);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
