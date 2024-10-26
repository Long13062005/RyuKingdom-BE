package com.example.hotelproject.security.auth.controller;

import com.example.hotelproject.controller.dto.response.MessengerRes;
import com.example.hotelproject.security.auth.request.AuthReq;
import com.example.hotelproject.security.auth.request.RegisterReq;
import com.example.hotelproject.security.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<MessengerRes> register(@RequestBody RegisterReq reg) {
        return ResponseEntity.ok(authService.register(reg));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<MessengerRes> login(@RequestBody AuthReq req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/auth/refresh")
    public ResponseEntity<MessengerRes> refreshToken(@RequestBody AuthReq req) {
        return ResponseEntity.ok(authService.refreshToken(req));
    }

    @PostMapping("/auth/logout")
    public ResponseEntity<MessengerRes> logout(@RequestBody AuthReq req) {
        return ResponseEntity.ok(authService.logout(req));
    }


}
