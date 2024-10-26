package com.example.hotelproject.service;

import com.example.hotelproject.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public <T> List<T> findAll(Class<T> classType);
    public <T> T findById(int id, Class<T> classType);
    public Employee save(Employee customer);
    public void deleteById(int id);
    <T> List<T> searchByEmployeeName(String name,  Class<T> classType);

    <T> T findByEmail(String email);
}
