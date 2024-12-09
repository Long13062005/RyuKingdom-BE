package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.EmployeeDto;
import com.example.hotelproject.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    EmployeeDto findById(Long id);

    Employee save(EmployeeDto employeeDto);

    void delete(Long id);

    List<Employee> searchEmployee(String search);

    Employee update(EmployeeDto employeeDto, Long id);
}
