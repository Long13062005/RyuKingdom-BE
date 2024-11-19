package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.TypeFacility;
import com.example.hotelproject.repository.TypeFacilityRepository;
import com.example.hotelproject.service.ITypeFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeFacilityService implements ITypeFacilityService {

    @Autowired
    private TypeFacilityRepository typeFacilityRepository;
    @Override
    public void deleteTypeFacility(Long id) {

    }

    @Override
    public void updateTypeFacility(Long id, String name) {

    }

    @Override
    public void addTypeFacility(String name) {

    }

    @Override
    public List<TypeFacility> getAllTypeFacilities() {
        return typeFacilityRepository.findAll();
    }


    @Override
    public void getTypeFacilityById(Long id) {

    }

    @Override
    public void getTypeFacilityByName(String name) {

    }
}
