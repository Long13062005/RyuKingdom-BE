package com.example.hotelproject.service;

public interface IUserService {
    void deleteUser(Long id);
    void updateUser(Long id, String name);
    void addUser(String name);
    void getAllUsers();
    void getUserById(Long id);
    void getUserByName(String name);
}
