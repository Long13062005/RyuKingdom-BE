package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.EmployeeDto;
import com.example.hotelproject.controller.dto.response.FacilityDto;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    EmployeeDto findById(Long id);

    Employee save(EmployeeDto employeeDto);

    void delete(Long id);

    List<Facility> searchEmployee(String search);

    Employee update(EmployeeDto employeeDto, Long id);
}
