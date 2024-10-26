package com.example.hotelproject.service.impl;

import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Override
    public <T> List<T> findAll(Class<T> classType) {
        return null;
    }

    @Override
    public <T> T findById(int id, Class<T> classType) {
        return null;
    }

    @Override
    public Employee save(Employee customer) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public <T> List<T> searchByEmployeeName(String name, Class<T> classType) {
        return null;
    }

    @Override
    public <T> T findByEmail(String email) {
        return null;
    }
}
