package com.example.hotelproject.service;

import com.example.hotelproject.entities.Position;

import java.util.List;

public interface IPositionService {
    void deletePosition(Long id);
    void updatePosition(Long id, String name);
    void addPosition(String name);
    List<Position> getAllPositions();
    void getPositionById(Long id);
    void getPositionByName(String name);
}
