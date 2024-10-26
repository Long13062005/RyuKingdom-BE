package com.example.hotelproject.service;

public interface IDivisionService {
    void deleteDivision(Long id);
    void updateDivision(Long id, String name);
    void addDivision(String name);
    void getAllDivisions();
    void getDivisionById(Long id);
    void getDivisionByName(String name);
}
