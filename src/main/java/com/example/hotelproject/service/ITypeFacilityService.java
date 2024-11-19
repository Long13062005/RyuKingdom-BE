package com.example.hotelproject.service;

import com.example.hotelproject.entities.TypeFacility;

import java.util.List;

public interface ITypeFacilityService {
    void deleteTypeFacility(Long id);
    void updateTypeFacility(Long id, String name);
    void addTypeFacility(String name);
    List<TypeFacility> getAllTypeFacilities();
    void getTypeFacilityById(Long id);
    void getTypeFacilityByName(String name);
}
