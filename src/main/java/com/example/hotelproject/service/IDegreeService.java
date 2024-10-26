package com.example.hotelproject.service;

public interface IDegreeService {
    void deleteDegree(Long id);
    void updateDegree(Long id, String name);
    void addDegree(String name);
    void getAllDegrees();
    void getDegreeById(Long id);
    void getDegreeByName(String name);
}
