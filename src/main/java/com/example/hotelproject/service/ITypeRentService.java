package com.example.hotelproject.service;

import com.example.hotelproject.entities.TypeRent;

import java.util.List;

public interface ITypeRentService {
    void deleteTypeRent(Long id);
    void updateTypeRent(Long id, String name);
    void addTypeRent(String name);
    List<TypeRent> getAllTypeRents();
    void getTypeRentById(Long id);
    void getTypeRentByName(String name);
}
