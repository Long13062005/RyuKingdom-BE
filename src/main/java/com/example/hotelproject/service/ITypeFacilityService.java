package com.example.hotelproject.service;

public interface ITypeFacilityService {
    void deleteTypeFacility(Long id);
    void updateTypeFacility(Long id, String name);
    void addTypeFacility(String name);
    void getAllTypeFacilities();
    void getTypeFacilityById(Long id);
    void getTypeFacilityByName(String name);
}
