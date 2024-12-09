package com.example.hotelproject.service.impl;

import com.example.hotelproject.controller.dto.response.EmployeeDto;
import com.example.hotelproject.entities.Division;
import com.example.hotelproject.entities.Employee;
import com.example.hotelproject.entities.Facility;
import com.example.hotelproject.repository.*;
import com.example.hotelproject.security.user_auth.model.User;
import com.example.hotelproject.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DivisionRepository divisionRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.getAll();
    }

    @Override
    public EmployeeDto findById(Long id) {
        EmployeeDto employeeDto = new EmployeeDto();
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = employee.getUser();
        employeeDto.setUsername(user.getUsername());
        employeeDto.setRole(user.getRole().getName());
        employeeDto.setId(employee.getId());
        employeeDto.setIdCard(employee.getIdCard());
        employeeDto.setName(employee.getName());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setDob(employee.getDob());
        employeeDto.setSalary(employee.getSalary());
        employeeDto.setDivision(employee.getDivision().getName());
        employeeDto.setPosition(employee.getPosition().getName());
        employeeDto.setDeleted(employee.isDeleted());
        employeeDto.setDegree(employee.getDegree().getName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setGender(
                switch (employee.getGender()) {
                    case 1 -> "Male";
                    case 2 -> "Female";
                    default -> "Other";
                });
        return employeeDto;
    }

    @Override
    public Employee save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        User user = new User();
        user.setUsername(employeeDto.getUsername());
        user.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        user.setRole(roleRepository.findByName(employeeDto.getRole()));
        userRepository.save(user);
        employee.setId(employeeDto.getId());
        employee.setUser(user);
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setDob(employeeDto.getDob());
        employee.setSalary(employeeDto.getSalary());
        employee.setIdCard(employeeDto.getIdCard());
        employee.setDivision(divisionRepository.findByName(employeeDto.getDivision()));
        employee.setPosition(positionRepository.findByName(employeeDto.getPosition()));
        employee.setDegree(degreeRepository.findByName(employeeDto.getDegree()));
        employee.setDeleted(employeeDto.isDeleted());
        employee.setEmail(employeeDto.getEmail());
        employee.setGender(
                switch (employeeDto.getGender()) {
                    case "Male" -> 1;
                    case "Female" -> 2;
                    default -> 0;
                });

        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.softDeleteEmployeeById(id);
    }

    @Override
    public List<Employee> searchEmployee(String search) {
        return employeeRepository.searchEmployee(search);
    }

    @Override
    public Employee update(EmployeeDto employeeDto, Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = employee.getUser();
        user.setUsername(employeeDto.getUsername());
        userRepository.save(user);
        System.out.println(user);
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setDob(employeeDto.getDob());
        employee.setSalary(employeeDto.getSalary());
        employee.setIdCard(employeeDto.getIdCard());
        employee.setDivision(divisionRepository.findByName(employeeDto.getDivision()));
        employee.setPosition(positionRepository.findByName(employeeDto.getPosition()));
        employee.setDegree(degreeRepository.findByName(employeeDto.getDegree()));
        employee.setDeleted(employeeDto.isDeleted());
        employee.setEmail(employeeDto.getEmail());
        employee.setGender(
                switch (employeeDto.getGender()) {
                    case "Male" -> 1;
                    case "Female" -> 2;
                    default -> 0;
                });
        return employeeRepository.save(employee);
    }
}
