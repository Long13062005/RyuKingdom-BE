package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.TypeRent;
import com.example.hotelproject.repository.TypeRentRepository;
import com.example.hotelproject.service.ITypeRentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRentService implements ITypeRentService {

    @Autowired
    private TypeRentRepository typeRentRepository;
    @Override
    public void deleteTypeRent(Long id) {

    }

    @Override
    public void updateTypeRent(Long id, String name) {

    }

    @Override
    public void addTypeRent(String name) {

    }

    @Override
    public List<TypeRent> getAllTypeRents(){
        return typeRentRepository.findAll();
    }

    @Override
    public void getTypeRentById(Long id) {

    }

    @Override
    public void getTypeRentByName(String name) {

    }
}
