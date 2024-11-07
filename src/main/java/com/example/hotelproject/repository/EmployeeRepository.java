package com.example.hotelproject.repository;

import com.example.hotelproject.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
        Employee findByUser_Username(String username);
}
