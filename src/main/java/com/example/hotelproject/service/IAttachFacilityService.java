package com.example.hotelproject.service;

public interface IAttachFacilityService {
    void deleteAttachFacility(Long id);
    void updateAttachFacility(Long id, String name);
    void addAttachFacility(String name);
    void getAllAttachFacilities();
    void getAttachFacilityById(Long id);
    void getAttachFacilityByName(String name);
}
