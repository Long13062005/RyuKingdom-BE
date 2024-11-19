package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Position;
import com.example.hotelproject.repository.PositionRepository;
import com.example.hotelproject.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public void deletePosition(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void updatePosition(Long id, String name) {
        // TODO Auto-generated method stub
    }

    @Override
    public void addPosition(String name) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Position> getAllPositions() {
        // TODO Auto-generated method stub
        return positionRepository.findAll();
    }

    @Override
    public void getPositionById(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void getPositionByName(String name) {
        // TODO Auto-generated method stub
    }
}
