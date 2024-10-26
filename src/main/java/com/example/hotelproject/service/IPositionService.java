package com.example.hotelproject.service;

public interface IPositionService {
    void deletePosition(Long id);
    void updatePosition(Long id, String name);
    void addPosition(String name);
    void getAllPositions();
    void getPositionById(Long id);
    void getPositionByName(String name);
}
