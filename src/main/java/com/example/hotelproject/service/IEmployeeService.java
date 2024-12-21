package com.example.hotelproject.service;

import com.example.hotelproject.controller.dto.response.EmployeeDto;
import com.example.hotelproject.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findEmployeesByName(String name, Pageable pageable);

    List<Employee> findAll();

    EmployeeDto findById(Long id);

    Employee save(EmployeeDto employeeDto);

    void delete(Long id);

    List<Employee> searchEmployee(String search);

    Employee update(EmployeeDto employeeDto, Long id);
}
