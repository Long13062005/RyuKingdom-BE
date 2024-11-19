package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Division;
import com.example.hotelproject.repository.DivisionRepository;
import com.example.hotelproject.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public void deleteDivision(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void updateDivision(Long id, String name) {
        // TODO Auto-generated method stub
    }

    @Override
    public void addDivision(String name) {
        // TODO Auto-generated method stub
    }

    @Override
    public List<Division> getAllDivisions() {
        // TODO Auto-generated method stub
        return divisionRepository.findAll();
    }

    @Override
    public void getDivisionById(Long id) {
        // TODO Auto-generated method stub
    }

    @Override
    public void getDivisionByName(String name) {
        // TODO Auto-generated method stub
    }
}
