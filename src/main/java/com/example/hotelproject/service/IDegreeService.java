package com.example.hotelproject.service;

import com.example.hotelproject.entities.Degree;

import java.util.List;

public interface IDegreeService {
    void deleteDegree(Long id);
    void updateDegree(Long id, String name);
    void addDegree(String name);
    List<Degree> getAllDegrees();
    void getDegreeById(Long id);
    void getDegreeByName(String name);
}
