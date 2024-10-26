package com.example.hotelproject.service;

public interface ITypeRentService {
    void deleteTypeRent(Long id);
    void updateTypeRent(Long id, String name);
    void addTypeRent(String name);
    void getAllTypeRents();
    void getTypeRentById(Long id);
    void getTypeRentByName(String name);
}
